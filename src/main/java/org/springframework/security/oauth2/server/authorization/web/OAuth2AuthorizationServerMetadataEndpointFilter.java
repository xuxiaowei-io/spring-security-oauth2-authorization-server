/*
 * Copyright 2020-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.oauth2.server.authorization.web;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponseType;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationServerMetadata;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContext;
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder;
import org.springframework.security.oauth2.server.authorization.http.converter.OAuth2AuthorizationServerMetadataHttpMessageConverter;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A {@code Filter} that processes OAuth 2.0 Authorization Server Metadata Requests.
 *
 * @author Daniel Garnier-Moiroux
 * @author Joe Grandja
 * @since 0.1.1
 * @see OAuth2AuthorizationServerMetadata
 * @see AuthorizationServerSettings
 * @see <a target="_blank" href="https://tools.ietf.org/html/rfc8414#section-3">3. Obtaining Authorization Server Metadata</a>
 */
public final class OAuth2AuthorizationServerMetadataEndpointFilter extends OncePerRequestFilter {
	/**
	 * The default endpoint {@code URI} for OAuth 2.0 Authorization Server Metadata requests.
	 */
	private static final String DEFAULT_OAUTH2_AUTHORIZATION_SERVER_METADATA_ENDPOINT_URI = "/.well-known/oauth-authorization-server";

	private final RequestMatcher requestMatcher = new AntPathRequestMatcher(
			DEFAULT_OAUTH2_AUTHORIZATION_SERVER_METADATA_ENDPOINT_URI,
			HttpMethod.GET.name());
	private final OAuth2AuthorizationServerMetadataHttpMessageConverter authorizationServerMetadataHttpMessageConverter =
			new OAuth2AuthorizationServerMetadataHttpMessageConverter();
	private Consumer<OAuth2AuthorizationServerMetadata.Builder> authorizationServerMetadataCustomizer = (authorizationServerMetadata) -> {};

	/**
	 * Sets the {@code Consumer} providing access to the {@link OAuth2AuthorizationServerMetadata.Builder}
	 * allowing the ability to customize the claims of the Authorization Server's configuration.
	 *
	 * @param authorizationServerMetadataCustomizer the {@code Consumer} providing access to the {@link OAuth2AuthorizationServerMetadata.Builder}
	 * @since 0.4.0
	 */
	public void setAuthorizationServerMetadataCustomizer(Consumer<OAuth2AuthorizationServerMetadata.Builder> authorizationServerMetadataCustomizer) {
		Assert.notNull(authorizationServerMetadataCustomizer, "authorizationServerMetadataCustomizer cannot be null");
		this.authorizationServerMetadataCustomizer = authorizationServerMetadataCustomizer;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (!this.requestMatcher.matches(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		AuthorizationServerContext authorizationServerContext = AuthorizationServerContextHolder.getContext();
		String issuer = authorizationServerContext.getIssuer();
		AuthorizationServerSettings authorizationServerSettings = authorizationServerContext.getAuthorizationServerSettings();

		OAuth2AuthorizationServerMetadata.Builder authorizationServerMetadata = OAuth2AuthorizationServerMetadata.builder()
				.issuer(issuer)
				.authorizationEndpoint(asUrl(issuer, authorizationServerSettings.getAuthorizationEndpoint()))
				.deviceAuthorizationEndpoint(asUrl(issuer, authorizationServerSettings.getDeviceAuthorizationEndpoint()))
				.tokenEndpoint(asUrl(issuer, authorizationServerSettings.getTokenEndpoint()))
				.tokenEndpointAuthenticationMethods(clientAuthenticationMethods())
				.jwkSetUrl(asUrl(issuer, authorizationServerSettings.getJwkSetEndpoint()))
				.responseType(OAuth2AuthorizationResponseType.CODE.getValue())
				.grantType(AuthorizationGrantType.AUTHORIZATION_CODE.getValue())
				.grantType(AuthorizationGrantType.CLIENT_CREDENTIALS.getValue())
				.grantType(AuthorizationGrantType.REFRESH_TOKEN.getValue())
				.grantType(AuthorizationGrantType.DEVICE_CODE.getValue())
				.tokenRevocationEndpoint(asUrl(issuer, authorizationServerSettings.getTokenRevocationEndpoint()))
				.tokenRevocationEndpointAuthenticationMethods(clientAuthenticationMethods())
				.tokenIntrospectionEndpoint(asUrl(issuer, authorizationServerSettings.getTokenIntrospectionEndpoint()))
				.tokenIntrospectionEndpointAuthenticationMethods(clientAuthenticationMethods())
				.codeChallengeMethod("S256");

		this.authorizationServerMetadataCustomizer.accept(authorizationServerMetadata);

		ServletServerHttpResponse httpResponse = new ServletServerHttpResponse(response);
		this.authorizationServerMetadataHttpMessageConverter.write(
				authorizationServerMetadata.build(), MediaType.APPLICATION_JSON, httpResponse);
	}

	private static Consumer<List<String>> clientAuthenticationMethods() {
		return (authenticationMethods) -> {
			authenticationMethods.add(ClientAuthenticationMethod.CLIENT_SECRET_BASIC.getValue());
			authenticationMethods.add(ClientAuthenticationMethod.CLIENT_SECRET_POST.getValue());
			authenticationMethods.add(ClientAuthenticationMethod.CLIENT_SECRET_JWT.getValue());
			authenticationMethods.add(ClientAuthenticationMethod.PRIVATE_KEY_JWT.getValue());
		};
	}

	private static String asUrl(String issuer, String endpoint) {
		return UriComponentsBuilder.fromUriString(issuer).path(endpoint).toUriString();
	}

}
