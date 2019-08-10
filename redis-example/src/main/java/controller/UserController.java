package controller;


import entity.User;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by lenovo on 2019/8/7.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public void findAll(){
        List<User> list = userService.findAll();
        System.out.println("user信息："+list);
    }

    @RequestMapping("list2")
    public void findUserById(@RequestParam(defaultValue = "12") Integer id){
        List<User> userList = userService.findUserById(id);
        System.out.println("根据ID获取用户信息："+userList);
    }

    //查询所有用户
    //@RequestMapping("list")
    //public String getAll(Model model) throws Exception{
    //    List<User> userList = userService.findAll();
    //    System.out.println("list:"+userList);
    //    model.addAttribute("userList",userList);
    //    return "success";
    //}

}
