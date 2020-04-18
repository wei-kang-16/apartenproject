package com.offcn.login.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.offcn.entity.User;
import com.offcn.exception.ExceptionCast;
import com.offcn.login.service.UserService;
import com.offcn.response.CommonCode;
import com.offcn.response.QueryResponseResult;
import com.offcn.utils.CookieUtil;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class LoginController {

        @Autowired
        private UserService userService;

        @Autowired
        private HttpServletRequest request;

        @Autowired
        StringRedisTemplate stringRedisTemplate;


        @PostMapping("/login")
        public QueryResponseResult login(@RequestParam("uname") String uname,
                                         @RequestParam("upwd") String upwd){
            User user = userService.findUserByUname(uname);
            if(user == null){
                ExceptionCast.cast(CommonCode.LONGINERROR);
            }
            if(!user.getUpwd().equals(upwd)){
                ExceptionCast.cast(CommonCode.LONGINERROR);
            }
            //将令牌存储到redis
            UUID uuid = UUID.randomUUID();
            String token=uuid+user.getUserId();
            String userStr = JSON.toJSONString(user);
            stringRedisTemplate.boundValueOps(token).set(userStr,1200, TimeUnit.SECONDS);
            //将令牌存储到cookie
            this.saveCookie(token);
            return new QueryResponseResult(CommonCode.SUCCESS,token);
        }

    //将令牌存储到cookie
    private void saveCookie(String token){

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,"/","uid",token,-1,false);

    }
}
