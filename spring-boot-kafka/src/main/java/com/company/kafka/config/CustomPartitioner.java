package com.company.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;
import java.util.Random;

/**
 * 自定义分区类
 */
@Slf4j
public class CustomPartitioner implements Partitioner {

    private Random random = new Random();

    public void configure(Map<String, ?> configs) {
    }

    /**
     * 自定义分区算法实现
     *
     * @param topic      The topic name
     * @param key        The key to partition on (or null if no key)
     * @param keyBytes   serialized key to partition on (or null if no key)
     * @param value      The value to partition on or null
     * @param valueBytes serialized value to partition on or null
     * @param cluster    The current cluster metadata
     */
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        int numPartitions = 2;
        int res;
        if (value == null) {
            log.info("value is null");
            res = random.nextInt(numPartitions);
        } else {
            log.info("value is {}    hashcode is {}", value, value.hashCode());
            res = Math.abs(value.hashCode()) % numPartitions;
        }
        log.info("data partitions is {}", res);
        return res;
    }

    public void close() {
    }
}