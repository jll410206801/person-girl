package com.imooc.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component  //这个注解：把这个文件引入到spring容器中去
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //这里写业务逻辑代码：我们希望http在请求到controller里面的方法之前就把他们记录下来
    @Pointcut("execution(public * com.imooc.controller.GirlController.*(..))")  //方法里面两个点表示，任何参数都被拦截
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
//        logger.info("11111");
        //这里要写的是记录http的请求了。
        ServletRequestAttributes attributes =
                (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =  attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURL());   //后面的变量会填到{}里面去

        //method
        logger.info("method={}",request.getMethod());

        //IP
        logger.info("IP={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinpoint.getSignature().getDeclaringTypeName() + "."+
                                        joinpoint.getSignature().getName());

        //参数
        logger.info("args={}",joinpoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
        logger.info("2222");
    }

    //这里获取返回的内容
    @AfterReturning(returning = "object" , pointcut = "log()")  //returning里面的内容就是入参:object
    public void doAfterReturning(Object object){  //因为不知道传什么，这里写Object

        logger.info("response={}",object.toString());
    }

}
