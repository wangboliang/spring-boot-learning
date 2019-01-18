
# 为什么要用Spring Boot
Spring Boot 本身并不提供 Spring 框架的核心特性以及扩展功能，只是用于快速、敏捷地开发新一代基于 Spring 框架的应用程序。同时它集成了大量常用的第三方库配置（如 Redis、MongoDB、JPA、RabbitMQ、Quartz 等），Spring Boot 应用中这些第三方库几乎可以零配置进行开箱即用，大部分的 Spring Boot 应用都只需要非常少量的配置代码，开发者能够更加专注于业务逻辑。<br>
## Spring Boot特性
- ### 简化配置
 - [配置文件详解](http://blog.didispace.com/springbootproperties/)
- ### 内嵌Tomcat（默认使用）、Jetty和Underto容器,可以创建独立启动的应用程序
 - 如何定制和修改Servlet容器的相关配置
     - Servlet配置属性参考``org.springframework.boot.autoconfigure.web.ServerProperties``类
 - 自定义Servlet三大组件【Servlet、Filter、Listener】
     - ``ServletRegistrationBean``
	 - ``FilterRegistrationBean``
	 - ``ServletListenerRegistrationBean``
 - 使用外置的Servlet容器
     - *程序入口继承``SpringBootServletInitializer``类*
 	 - *打成war包，放入web容器*
- ### 提供Starter简化Maven配置
 - 集成多个第三方组件[Github](https://github.com/spring-projects/spring-boot/tree/v1.5.4.RELEASE/spring-boot-starters)
 - [自定义starter](https://github.com/wangboliang/customize-spring-boot-starter/blob/master/README.md)
- ### 外化配置
 - Spring Boot允许将配置外部化（externalize），这样你就能够在不同的环境下使用相同的代码。你可以使用properties文件，YAML文件，环境变量和命令行参数来外部化配置。使用@Value注解，可以直接将属性值注入到beans中，然后通过Spring的 Environment 抽象或通过 @ConfigurationProperties 绑定到结构化对象来访问。
 - 配置加载顺序参考[官方文档](https://docs.spring.io/spring-boot/docs/1.5.9.RELEASE/reference/htmlsingle/#boot-features-external-config)
- ### 监控
 - [参考文章](http://www.ityouknow.com/springboot/2018/02/06/spring-boot-actuator.html)
- ### 日志
 - [参考文章](https://blog.csdn.net/Inke88/article/details/75007649)


