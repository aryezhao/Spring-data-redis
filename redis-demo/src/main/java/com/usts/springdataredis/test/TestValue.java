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

/**
 * 值类型操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-redis.xml")
public class TestValue {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testValue(){
        redisTemplate.boundValueOps("name").set("itcast");
    }

    @Test
    public void getValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println("获取的值："+name);
    }

    @Test
    public void deleteValue(){
        redisTemplate.delete("name");
    }


}
