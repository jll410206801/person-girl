package com.imooc;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//这个类对应数据库中的表
@Entity
public class Girl {

    @Id
    @GeneratedValue  //id一般用作自增
    private Integer id;

    private String cupSize;

    private Integer age;


    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
