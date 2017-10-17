package com.redis;

import com.redis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTest {

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void testRedis() throws Exception {
        // 保存对象
        User user = new User(1L, "超人", 20);
        redisTemplate.opsForValue().set(user.getName(), user);
        user = new User(1L, "蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getName(), user);
        user = new User(1L, "蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getName(), user);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

    }

}
