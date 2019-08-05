package com.usts.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lenovo on 2019/8/5.
 */
public class JedisPoolDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JedisPool jedisPool = (JedisPool) applicationContext.getBean("jedisPool");

        Jedis jedis = null;

        jedis = jedisPool.getResource();
        jedis.set("name","兴业");
        String name = jedis.get("name");
        System.out.println("jedis的姓名是："+name);

        jedis.close();

        jedisPool.close();
    }
}
