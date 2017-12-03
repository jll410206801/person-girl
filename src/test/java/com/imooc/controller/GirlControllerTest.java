package com.imooc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)   //这个注解表示，要在测试环境里面跑。 它底层实现是JUnit测试工具
@SpringBootTest  //这个注解表示启动整个spring工程
@AutoConfigureMockMvc
public class GirlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void girlList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/girls"))
                    .andExpect(MockMvcResultMatchers.status().isOk());
    }

}