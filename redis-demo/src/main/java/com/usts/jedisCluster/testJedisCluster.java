package com.usts.jedisCluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2019/8/6.
 */

/**
 * 创建JedisCluster类连接redis集群
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-redis.xml")
public class testJedisCluster {

    @Test
    public void test1() throws IOException {

        //创建一连接，JedisCluster对象,在系统中是单例存在
        Set<HostAndPort> nodes = new HashSet<>();

        nodes.add(new HostAndPort("114.67.73.152", 7001));
        nodes.add(new HostAndPort("114.67.73.152", 7002));
        nodes.add(new HostAndPort("114.67.73.152", 7003));
        nodes.add(new HostAndPort("114.67.73.152", 7004));
        nodes.add(new HostAndPort("114.67.73.152", 7005));
        nodes.add(new HostAndPort("114.67.73.152", 7006));

        JedisCluster cluster = new JedisCluster(nodes);
        //执行JedisCluster对象中的方法，方法和redis一一对应。
        cluster.set("cluster-test", "my jedis cluster test");
        String result = cluster.get("cluster-test");
        System.out.println(result);
        //程序结束时需要关闭JedisCluster对象
        cluster.close();
    }
}
