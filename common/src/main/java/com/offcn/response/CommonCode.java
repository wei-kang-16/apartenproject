package com.offcn.response;

import lombok.ToString;


@ToString
public enum CommonCode implements ResultCode{

    SUCCESS(true,10000,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    LONGINERROR(false,10002,"账号或密码错误！"),
    UNAUTHORISE(false,10003,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！");

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}