package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication  //说明这是springboot的一个应用
@EnableSwagger2
public class GirlApplication {



	public static void main(String[] args) {
		//项目入口
		//直接运行主函数是运行一个jar包，也就是说现在的web项目变成一个jar包了
		SpringApplication.run(GirlApplication.class, args);
	}





}
