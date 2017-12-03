package com.imooc;


import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)   //这个注解表示，要在测试环境里面跑。 它底层实现是JUnit测试工具
@SpringBootTest  //这个注解表示启动整个spring工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        Girl girl = girlService.findOne(7);
        Assert.assertEquals(new Integer(22), girl.getAge());
    }



}
