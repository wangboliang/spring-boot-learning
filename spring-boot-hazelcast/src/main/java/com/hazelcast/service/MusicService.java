package com.hazelcast.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 描述
 * </p>
 *
 * @author wangliang
 * @since 2017/10/17
 */
@Service
@CacheConfig(cacheNames = "instruments")
public class MusicService {

    private static Logger log = LoggerFactory.getLogger(MusicService.class);

    @CacheEvict(allEntries = true)
    public void clearCache(){}

    @Cacheable(condition = "#instrument.equals('trombone')")
    public String play(String instrument) {
        log.info("Executing: " + this.getClass().getSimpleName() + ".play(\"" + instrument + "\");");
        return "paying " + instrument + "!";
    }

}
