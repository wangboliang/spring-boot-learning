package com.redis.service;

import com.redis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * service
 * </p>
 *
 * @author wangliang
 * @since 2017/10/17
 */
@Slf4j
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 如果缓存存在，从缓存中获取信息
     * 如果缓存不存在，从 DB 中获取信息，然后插入缓存
     */
    public User findById(Long id) {
        // 从缓存中获取城市信息
        String key = "user" + id;
        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            User user = operations.get(key);

            log.info("RedisService.findById() : 从缓存中获取了 >> ", user);
            return user;
        }

        //Todo 从 DB 中获取信息
        //User user = dao.findById(id);
        User user = new User();

        // 插入缓存
        operations.set(key, user, 10, TimeUnit.SECONDS);
        log.info("RedisService.findById() : 从缓存中获取了 >> ", user);

        return user;
    }

    /**
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    public Long updateUser(User user) {
        //Todo DB 中修改信息
        //Long result = dao.updateCity(user);
        Long result = 1L;

        // 缓存存在，删除缓存
        String key = "user" + user.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            log.info("RedisService.updateUser() : 从缓存中删除 >> ", user);
        }

        return result;
    }

    public Long deleteUser(Long id) {
        //Todo DB 中删除信息
        //Long result = dao.deleteCity(id);
        Long result = 1L;

        // 缓存存在，删除缓存
        String key = "user" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            log.info("RedisService.deleteUser() : 从缓存中删除 ID >> ", id);
        }
        return result;
    }

}
