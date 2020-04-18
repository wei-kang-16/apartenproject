package com.offcn.aop;

import com.alibaba.fastjson.JSON;
import com.offcn.entity.User;
import com.offcn.exception.ExceptionCast;
import com.offcn.response.CommonCode;
import com.offcn.utils.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class Advice02 {

    RedisTemplate RedisTemplate;


    @Pointcut(value = "execution(public * com.offcn.consume..*.*(..))")
    public void auth(){}

    @Before("auth()")
    public  void getToken(){
        //每次请求从Redis拿令牌进行访问
        int tokenNum = (int)RedisTemplate.boundValueOps("token").get();
        if(tokenNum>0){
            //拿到令牌Redis令牌减一
            RedisTemplate.boundValueOps("token").set(tokenNum-1);
        }else {
            //如果令牌没有了，就禁止访问
            //系统繁忙请稍后重试
            ExceptionCast.cast(CommonCode.SERVER_ERROR);
        }
    }



}
