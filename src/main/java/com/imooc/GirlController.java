package com.imooc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    //这里逻辑简单，就直接在controller里面直接调用
    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return List<Girl>
     */
    //spring-jpa 操作数据库非常简单，不用写sql语句
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){

        return girlRepository.findAll();
    }

    /**
     * 增加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();

        girl.setCupSize(cupSize);
        girl.setAge(age);

        return  girlRepository.save(girl);  //返回的是添加的对象

    }

    //通过id查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
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


}
