package service.impl;


import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

/**
 * Created by lenovo on 2019/8/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> findAll() {
        try{
            //先查询缓存
            List<User> userList = (List<User>) redisTemplate.boundHashOps("list").keys();
            //判断缓存数据是否存在
            if(!userList.isEmpty() && userList.size() > 0){
                System.out.println("从缓存读取数据");
                return userList;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //执行查询
        List<User> userList = userMapper.findAll();

        //添加缓存数据
        redisTemplate.boundHashOps("list").put(userList,userList);
        System.out.println("从数据库读取并存入缓存数据");
        return userList;
    }

    @Override
    public List<User> findUserById(Integer id) {
        try{
            List<User> user = (List<User>) redisTemplate.boundHashOps("user").get(id);
            //判断缓存数据是否存在
            if(!user.isEmpty() && user.size() > 0){
                System.out.println("从缓存读取数据");
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        //执行查询
        List<User> list = userMapper.findUserById(id);

        //添加缓存数据
        redisTemplate.boundHashOps("user").put(id,list);
        System.out.println("从数据库读取并存入缓存数据");
        return list;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }
}
