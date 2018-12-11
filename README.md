# Spring Boot学习
### 为什么要用Spring Boot
### Spring Boot特性
1. 简化配置<br>
遵循“约定大于配置”原则，简化配置
2. 内置servlet容器<br>
内置tomcat、jetty容器，应用可直接打成jar包运行
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-tomcat</artifactId>
</dependency>
```
3. 监控<br>
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```
4. 日志<br>
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-logging</artifactId>
</dependency>
```
5. 外化配置<br>
Spring Boot允许你针对不同的环境配置不同的配置参数，你可以使用 properties文件、YAML 文件、环境变量或者命令行参数来修改应用的配置。你可以在代码中使用@Value注解来获取配置参数的值。
### Spring Boot Starter
### Spring Boot集成
