package com.imooc.controller;


import com.imooc.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//支持restful风格的访问方式 @RestController等同于@Controller和@ResponseBody的组合
//写上这个注解，自动返回json格式数据
@RestController
public class UserController {

    /**
     * 需求：返回基本类型json格式数据
     */
    @RequestMapping("hello")
    public String showHello(){
        return "helloddddddd";
    }


    /**
     * 需求：返回一个POJO对象
     */
    @RequestMapping("pojo")
    public User showUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("zsan");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("武当山");
        return  user;
    }

    /**
     * 需求：返回Map集合对象
     */
    @RequestMapping("maps")
    public Map<String,Object> showMaps(){
        Map<String,Object> maps = new HashMap<>();
        maps.put("username","张无忌");
        maps.put("age","19");
        return maps;
    }

    /**
     * 需求：返回List集合对象
     */
    @RequestMapping("list")
    public List<User> showList(){
        List<User> userList = new ArrayList<>();

        User user1 = new User();
        user1.setId(1);
        user1.setUsername("zsan");
        user1.setSex("男");
        user1.setBirthday(new Date());
        user1.setAddress("武当山");
        User user2 = new User();
        user2.setId(1);
        user2 .setUsername("lisi");
        user2.setSex("男");
        user2.setBirthday(new Date());
        user2.setAddress("湖南");

        userList.add(user1);
        userList.add(user2);
        return userList;
    }

}
