package com.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RedisApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(
                RedisApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
