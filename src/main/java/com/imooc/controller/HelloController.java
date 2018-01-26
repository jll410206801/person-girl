package com.imooc.controller;

import com.imooc.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *启动应用的方式很多
 * 1、IDEA run
 * 2、项目文件下，执行mvn spring-boot:run
 * 3、进到项目目录：先编译，然后运行java -jar 项目jar包名
 */

@RestController
public class HelloController {
    /*
    //通过注解把yml中的内容注入到属性变量里面去了
    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private String age;

    //在配置里面使用当前配置
    @Value("${content}")
    private String content;
    */
    @Autowired
    private GirlProperties girlProperties;


//    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
//    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @PostMapping(value = "/say")
//    public String say(@RequestParam(value = "id",required = false,defaultValue = "0") Integer myId){
    public String say(@PathVariable("id") Integer myId){
        return "id: " + myId;
//        return girlProperties.getCupSize();
    }
}
