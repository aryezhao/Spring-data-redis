package mapper;


import entity.User;

import java.util.List;

/**
 * Created by lenovo on 2019/7/4.
 */
public interface UserMapper {


    List<User> findAll();

    List<User> findUserById(Integer id);

    void addUser(User user);


}
