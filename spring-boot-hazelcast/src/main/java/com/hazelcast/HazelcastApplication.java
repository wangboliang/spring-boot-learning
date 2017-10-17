package com.hazelcast;

import com.hazelcast.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@EnableCaching
@SpringBootApplication
public class HazelcastApplication implements CommandLineRunner {

    @Autowired
    private MusicService musicService;

    @Autowired
    private CacheManager cacheManager;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HazelcastApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Spring Boot Hazelcast Caching Example Configuration");
        log.info("Using cache manager: " + cacheManager.getClass().getName());

        musicService.clearCache();

        play("trombone");
        play("guitar");
        play("trombone");
        play("bass");
        play("trombone");
    }

    private void play(String instrument){
        log.info("Calling: " + MusicService.class.getSimpleName() + ".play(\"" + instrument + "\");");
        musicService.play(instrument);
    }
}
