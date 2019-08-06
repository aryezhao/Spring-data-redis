package com.usts.jedisCluster;

/**
 * Created by lenovo on 2019/8/6.
 */

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

/**
 * jedisPoolConfig 根据集群配置  测试Jedis连接集群
 */
public class JedisPoolConfig {

    private ApplicationContext applicationContext;
    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext-jediscluster.xml");
    }

    // redis集群
    @Test
    public void testJedisCluster() {
        JedisCluster jedisCluster = (JedisCluster) applicationContext
                .getBean("jedisCluster");
        jedisCluster.set("bank", "交通银行");
        String value = jedisCluster.get("bank");
        System.out.println(value);
    }

}
