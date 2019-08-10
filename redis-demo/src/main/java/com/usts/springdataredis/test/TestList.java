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

import java.util.List;

/**
 * List类型操作
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext-redis.xml")
public class TestList {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 右压栈
     */
    @Test
    public void testSet(){
        redisTemplate.boundListOps("namelist2").leftPush("交通银行");
        redisTemplate.boundListOps("namelist2").leftPush("兴业银行");
        redisTemplate.boundListOps("namelist2").leftPush("中国银行");
    }

    /**
     * 显示左压栈集合
     */
    @Test
    public void testget(){
        List list = redisTemplate.boundListOps("namelist2").range(0, 10);
        System.out.println(list);
    }

    /**
     * 根据索引查询元素
     */
    @Test
    public void testGetByIndex(){
        Object namelist2 = redisTemplate.boundListOps("namelist2").index(1);
        System.out.println("第二个元素是："+namelist2);
    }

    /**
     * 移除某个元素
     */
    @Test
    public void testRemove(){
        redisTemplate.boundListOps("namelist2").remove(1,"交通银行");
    }
}
