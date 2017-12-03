package com.imooc.controller;


import com.imooc.domain.Result;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.domain.Girl;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    //这里逻辑简单，就直接在controller里面直接调用
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    //目的：每次发请求要验证是否登陆
    //思路1不可行：加个构造方法，不可行，因为spring程序启动的时候已经把这些类实例化了，http请求再来的时候是不会执行构造方法的
    //使用AOP

    /**
     * 查询所有女生列表
     * @return List<Girl>
     */
    //spring-jpa 操作数据库非常简单，不用写sql语句
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
//        return null;
    }

    /**
     * 增加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) { //验证结果返回给bindingResult
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }

    //通过id查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        //通过id查询
        return girlRepository.findOne(id);
    }


    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return  girlRepository.save(girl);

    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void firlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }


    //通过age查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }


    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    //controller把service来的异常抛给ExceptionHandle。。这样的话对异常处理的逻辑就都放在ExceptionHandle里统一处理了。
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }


}
