package com.usts.springdataredis.test;

/**
 * Created by lenovo on 2019/8/9.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Hash类型操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-redis.xml")
public class TestHash {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 存入值
     */
    @Test
    public void testSetValue(){
        redisTemplate.boundHashOps("namehash").put("a","唐僧");
        redisTemplate.boundHashOps("namehash").put("b","猪八戒");
        redisTemplate.boundHashOps("namehash").put("c","沙僧");
        redisTemplate.boundHashOps("namehash").put("d","白龙马");
    }
    /**
     * 提取所有的key
     */
    @Test
    public void testGetKeys(){
        //Set set = redisTemplate.boundHashOps("namehash").keys();
        Set set = redisTemplate.boundHashOps("list").keys();
        System.out.println("hash获取key："+set+"，获取值：");
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
    /**
     * 获取所有的值
     */
    @Test
    public void testGetValue(){
        List list = redisTemplate.boundHashOps("namehash").values();
        System.out.println("hash获取的值是："+list);
    }
    /**
     * 根据key获取值
     */
    @Test
    public void testGetValueByKey(){
        Object o = redisTemplate.boundHashOps("namehash").get("a");
        System.out.println(o);
    }
    /**
     * 根据key移除值
     */
    @Test
    public void testRemoveValueByKey(){
        redisTemplate.boundHashOps("namehash").delete("c");
    }
}
