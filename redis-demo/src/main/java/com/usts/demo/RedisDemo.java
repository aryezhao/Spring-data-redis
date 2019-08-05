package com.usts.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by lenovo on 2019/8/5.
 */
public class RedisDemo {

    public static void main(String[] args) {

        //testJedis();

        testJedisPool();

    }

    /**
     * 单实例连接
     */
    public static void testJedis(){

        //创建一个jedis连接
        Jedis jedis = new Jedis("114.67.73.152",6379);

        //设置数据库
        jedis.select(0);

        //执行redis命令
        jedis.set("mytest","hello world,兴业银行");

        //从redis中取值
        String mytest = jedis.get("mytest");

        //打印结果
        System.out.println("redis数据库结构是："+mytest);

        //关闭连接
        jedis.close();

    }

    public static void testJedisPool(){
        //创建一连接池对象
        JedisPool jedisPool = new JedisPool("114.67.73.152",6379);

        //从连接池中获取连接
        Jedis jedis = jedisPool.getResource();

        String mytest = jedis.get("mytest");
        System.out.println(mytest);

        jedis.close();

        jedisPool.close();
    }
}
