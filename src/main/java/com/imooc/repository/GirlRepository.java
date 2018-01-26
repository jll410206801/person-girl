package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer>{  //类名加上id的类型....id是int型


    //通过年龄来查询
    public List<Girl> findByAge(Integer age);

}
