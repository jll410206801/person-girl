package com.imooc.enums;


/**
 * 统一管理
 * 异常code和message的枚举
 */
public enum ResultEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学"),
    MIDDLE_SCHOOL(101,"可能在上初中"),

    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //这里用get方法就好
    //因为枚举的使用都是用构造方法去创建，不再重新set了
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
