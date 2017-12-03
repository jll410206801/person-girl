package com.imooc.handle;


import com.imooc.domain.Result;
import com.imooc.exception.GirlException;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常捕获
 */

@ControllerAdvice
public class ExceptionHandle {

    //打日志把异常记录下来
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody   //由于返回给浏览器的要是一个json格式，所以这里要加ResponseBody说明
    public Result handle(Exception e){
        //这里要判断下异常是不是自己定义的GirlException。
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else{
            //捕获系统异常
            logger.error("【系统异常】 {}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }


}
