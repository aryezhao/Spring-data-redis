package com.usts.springdataredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by lenovo on 2019/8/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-redis.xml")
public class SpringDataRedisDemo {

    /**
     * 注入spring-data-redis模板对象
     */
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 测试一：设置string类型
     */
    @Test
    public void test1(){
        redisTemplate.boundValueOps("username").set("张三丰");
    }
    /**
     * 测试一：获取string类型
     */
    @Test
    public void test2(){
        String username = (String) redisTemplate.boundValueOps("username").get();
        System.out.println(username);
    }
    /**
     * 测试一：删除string类型
     */
    @Test
    public void test3(){
        redisTemplate.delete("username");
    }

    /**
     * 测试二：set数据类型添加操作
     */
    @Test
    public void test4(){
        redisTemplate.boundSetOps("user").add("交通银行");
        redisTemplate.boundSetOps("user").add("江苏银行");
        redisTemplate.boundSetOps("user").add("中国银行");
    }
    /**
     * 测试二：获取set数据类型添加操作
     */
    @Test
    public void test5(){
        Set members = redisTemplate.boundSetOps("user").members();
        for (Object user :members) {
            System.out.println(user);
        }
    }

    /**
     * 测试二：删除set数据类型添加操作
     */
    @Test
    public void test6(){
        redisTemplate.delete("user");

    }

    /**
     * 测试三： list数据类型添加操作
     */
    @Test
    public void test7(){
        redisTemplate.boundListOps("list").leftPush("北京");
        redisTemplate.boundListOps("list").leftPush("上海");
        redisTemplate.boundListOps("list").leftPush("广州");
    }
    /**
     * 测试三： list数据类型获取操作
     */
    @Test
    public void test8(){
        Object list = redisTemplate.boundListOps("list").rightPop();
        System.out.println(list);
    }

    /**
     * 测试四： hash数据类型添加操作
     */
    @Test
    public void test9(){
        redisTemplate.boundHashOps("student").put("age","23");
        redisTemplate.boundHashOps("student").put("city","上海");
    }
    /**
     * 测试四： hash数据类型获取操作
     */
    @Test
    public void test10(){
        Object o = redisTemplate.boundHashOps("student").get("city");
        System.out.println(o);
    }



}
