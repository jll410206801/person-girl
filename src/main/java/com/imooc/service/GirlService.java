package com.imooc.service;


import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import com.imooc.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;


    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(16);
        girlRepository.save(girlB);

    }

    //service里面处理逻辑，如果验证不通过就抛异常，抛给controller
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            //返回你还在上小学 code=100  这里要区分100还是101，这个不好写，所以自己实现一个exception
            //还有个问题：code和message没有地方维护，想咋写就咋写。。这里需要统一管理，这里用到枚举
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 24){
            //返回上初中 code=101
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }


        //业务：age判断之后的一系列的操作：如果>16岁，加钱。。
    }

    /**
     * 通过id查询一个女生信息。单元测试用的
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }




}
