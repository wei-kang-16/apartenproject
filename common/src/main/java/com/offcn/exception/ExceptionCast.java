package com.offcn.exception;

import com.offcn.response.ResultCode;


public class ExceptionCast {
    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
