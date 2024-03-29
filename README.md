# 本项目为 [spring-authorization-server](https://github.com/spring-projects/spring-authorization-server) JDK 8/17、Spring 5.x.x/6.x.x（即：spring-boot 2.x.x/3.x.x） 的适配项目。

## 发布内容参见 [GitLab](https://gitlab.com/xuxiaowei-io/spring-security-oauth2-authorization-server/-/pipelines)

## 各版本支持说明

- spring-authorization-server 分为两个产品线，1.x 与 1.x 之前的版本
    - 1.x 之前
        - 支持 JDK 8/11（0.3.0 仅支持 JDK 11）
    - 1.x
        - 支持 JDK 17

- 本项目分为两个产品线
    - 1.x 之前
        - [0.3.0](https://s01.oss.sonatype.org/content/repositories/public/io/xuxiaowei/security/spring-security-oauth2-authorization-server/0.3.0/)
          -
          本人学习 [org.springframework.security:spring-security-oauth2-authorization-server](https://s01.oss.sonatype.org/content/repositories/public/org/springframework/security/spring-security-oauth2-authorization-server/)
          时，最新版为 0.3.0，仅支持 JDK 11。所以做了 JDK 8 的迁移。官方在 0.3.1 将 JDK 从 11 降回 8，并宣布以后在 1.x 之前使用
          JDK 8，1.x 使用 JDK 17。
        - [next-0.3.0](https://s01.oss.sonatype.org/content/repositories/public/io/xuxiaowei/security/next/spring-security-oauth2-authorization-server/0.3.0/)
            - 在官方未发布 1.x 之前时，将仅支持 JDK 8 的版本迁移至 JDK 17
        - [next-0.3.1](https://s01.oss.sonatype.org/content/repositories/public/io/xuxiaowei/security/next/spring-security-oauth2-authorization-server/0.3.1/)
            - 在官方未发布 1.x 之前时，将仅支持 JDK 8 的版本迁移至 JDK 17
        - 如无特殊情况，本项目的 1.x 之前的版本将不再更新，可直接使用官方版本。
    - 1.x-jdk8
        - 由于官方回复在 1.x
          之前不再更新新功能，仅进行错误及安全修复：[Does 0.4.x support device authorization ?](https://github.com/spring-projects/spring-authorization-server/issues/1147)。
        - 新功能（如：设备授权）仅发布在 1.x 版本，而 1.x 仅支持 JDK 17
        - 为了能在 JDK 8 中使用新功能（如：设备授权），所以发布了 1.x-jdk8 的版本

| [org.springframework.security:spring-security-oauth2-authorization-server](https://s01.oss.sonatype.org/content/repositories/public/org/springframework/security/spring-security-oauth2-authorization-server/) | MANIFEST.MF                                                                                                                                                                                                                                         | 支持 JDK 8                                                                                                                                                                                                          | 支持 JDK 11 | 支持 JDK 17 | 支持 Spring 版本 | 支持 Spring Security | 支持 Spring Boot 版本 |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------|-----------|--------------|--------------------|-------------------|
| 0.2.0                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.2.0/spring-security-oauth2-authorization-server-0.2.0.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.2.1                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.2.1/spring-security-oauth2-authorization-server-0.2.1.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.2.2                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.2.2/spring-security-oauth2-authorization-server-0.2.2.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.2.3                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.2.3/spring-security-oauth2-authorization-server-0.2.3.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.3.0                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.3.0/spring-security-oauth2-authorization-server-0.3.0.jar/!/META-INF/MANIFEST.MF) | ❌ 如果要在 JDK 8 环境中使用 0.3.0，可用 [io.xuxiaowei.security:spring-security-oauth2-authorization-server:0.3.0](https://repo1.maven.org/maven2/io/xuxiaowei/security/spring-security-oauth2-authorization-server/0.3.0/) 替代 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.3.1                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.3.1/spring-security-oauth2-authorization-server-0.3.1.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.4.0                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.4.0/spring-security-oauth2-authorization-server-0.4.0.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.4.1                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.4.1/spring-security-oauth2-authorization-server-0.4.1.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             | 
| 0.4.2                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/0.4.2/spring-security-oauth2-authorization-server-0.4.2.jar/!/META-INF/MANIFEST.MF) | ✅                                                                                                                                                                                                                 | ✅         | ❌         | 5.7.x        | 5.7.x              | 2.7.x             |
| 1.0.0                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/1.0.0/spring-security-oauth2-authorization-server-1.0.0.jar/!/META-INF/MANIFEST.MF) | ❌                                                                                                                                                                                                                 | ❌         | ✅         | 6.x.x        | 6.x.x              | 3.x.x             |
| 1.0.1                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/1.0.1/spring-security-oauth2-authorization-server-1.0.1.jar/!/META-INF/MANIFEST.MF) | ❌                                                                                                                                                                                                                 | ❌         | ✅         | 6.x.x        | 6.x.x              | 3.x.x             |
| 1.0.2                                                                                                                                                                                                          | [MANIFEST.MF](https://s01.oss.sonatype.org/service/local/repositories/releases/archive/org/springframework/security/spring-security-oauth2-authorization-server/1.0.2/spring-security-oauth2-authorization-server-1.0.2.jar/!/META-INF/MANIFEST.MF) | ❌                                                                                                                                                                                                                 | ❌         | ✅         | 6.x.x        | 6.x.x              | 3.x.x             |

| [io.xuxiaowei.security:spring-security-oauth2-authorization-server](https://s01.oss.sonatype.org/content/repositories/public/io/xuxiaowei/security/spring-security-oauth2-authorization-server/) | 支持 JDK 8 | 支持 JDK 11 | 支持 JDK 17 | 支持 Spring 版本 | 支持 Spring Security | 支持 Spring Boot 版本 | 说明                                                                             |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|-----------|-----------|--------------|--------------------|-------------------|--------------------------------------------------------------------------------|
| 1.1.0-M2-jdk8-*                                                                                                                                                                                  | ✅        | ✅         | ❌         | 5.x.x        | 5.x.x              | 2.x.x             | 基于 spring-authorization-server 仓库中的 1.1.0-M2 标签，修改为支持 JDK 8、Spring Boot 2.x.x  |
| 1.1.0-RC1-jdk8-*                                                                                                                                                                                 | ✅        | ✅         | ❌         | 5.x.x        | 5.x.x              | 2.x.x             | 基于 spring-authorization-server 仓库中的 1.1.0-RC1 标签，修改为支持 JDK 8、Spring Boot 2.x.x |
| 1.1.0-jdk8-*                                                                                                                                                                                     | ✅        | ✅         | ❌         | 5.x.x        | 5.x.x              | 2.x.x             | 基于 spring-authorization-server 仓库中的 1.1.0 标签，修改为支持 JDK 8、Spring Boot 2.x.x     |

| [io.xuxiaowei.security.next:spring-security-oauth2-authorization-server](https://s01.oss.sonatype.org/content/repositories/public/io/xuxiaowei/security/next/spring-security-oauth2-authorization-server/) | 支持 JDK 8 | 支持 JDK 11 | 支持 JDK 17 | 支持 Spring 版本 | 支持 Spring Security | 支持 Spring Boot 版本 | 说明 |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|-----------|-----------|--------------|--------------------|-------------------|----|
| 0.3.0                                                                                                                                                                                                      | ❌        | ❌         | ✅         | 6.x.x        | 6.x.x              | 3.x.x             |    | 
| 0.3.1                                                                                                                                                                                                      | ❌        | ❌         | ✅         | 6.x.x        | 6.x.x              | 3.x.x             |    | 

## 其他

```shell
gradlew :spring-security-oauth2-authorization-server:dependencies > D:\spring-authorization-server.txt
```

## 流水线

- 当前流水线：[极狐GitLab](https://jihulab.com/xuxiaowei-io/spring-security-oauth2-authorization-server/-/pipelines)
    - 国内版 GitLab，开源项目：不限制流水线使用时长
- 历史流水线：[GitLab](https://gitlab.com/xuxiaowei-io/spring-security-oauth2-authorization-server/-/pipelines)
    - 国际版 GitLab，开源项目：每个群组（用户）每个月400分钟
    - 以后不再使用

## 批量添加远端仓库地址

<details>
<summary>点击展开</summary>
git remote add gitee https://gitee.com/xuxiaowei-io/spring-security-oauth2-authorization-server.git

git remote add gitlab https://gitlab.com/xuxiaowei-io/spring-security-oauth2-authorization-server.git

git remote add jihulab https://jihulab.com/xuxiaowei-io/spring-security-oauth2-authorization-server.git

git remote add github https://github.com/xuxiaowei-io/spring-security-oauth2-authorization-server.git

git remote add gitcode https://gitcode.net/xuxiaowei-io/spring-security-oauth2-authorization-server.git

git remote add gitlink https://gitlink.org.cn/xuxiaowei-io/spring-security-oauth2-authorization-server.git
</details>
