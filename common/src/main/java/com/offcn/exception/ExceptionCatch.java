package com.offcn.exception;


import com.offcn.response.CommonCode;
import com.offcn.response.ResponseResult;
import com.offcn.response.ResultCode;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionCatch {

    //捕获 CustomException异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody  //json格式返回客户端
    public ResponseResult customException(CustomException e) {

        ResultCode resultCode = e.getResultCode();
        ResponseResult responseResult = new ResponseResult(resultCode);
        return responseResult;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
            return new ResponseResult(CommonCode.SERVER_ERROR);
    }

}
