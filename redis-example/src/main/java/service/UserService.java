package service;


import entity.User;

import java.util.List;

/**
 * Created by lenovo on 2019/8/7.
 */
public interface UserService {

    List<User> findAll();

    List<User> findUserById(Integer id);

    void addUser(User user);
}
