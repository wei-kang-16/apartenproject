package com.offcn.exception;

import com.offcn.response.ResultCode;


public class CustomException extends RuntimeException  {

    private ResultCode resultCode ;

    public CustomException (ResultCode resultCode ){
        //异常信息为错误代码+异常信息
        this.resultCode = resultCode ;
    }

    public ResultCode getResultCode (){
        return this.resultCode ;
    }

}
