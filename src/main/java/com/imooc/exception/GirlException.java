package com.imooc.exception;


import com.imooc.enums.ResultEnum;

/**
 *
 */
public class GirlException extends RuntimeException{
    //注意：这里要继承于RuntimeException 因为spring只会对runtimeException进行事务回滚，对exception是不回事务回滚的

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());  //父类本身就会传一个message
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
