package com.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HazelcastApplicationTest {

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @Test
    public void testHazelcast() throws Exception {
        IMap map =hazelcastInstance.getMap("test");
        map.put("one",1);
    }

}
