package com.offcn.aop;

import com.alibaba.fastjson.JSON;
import com.offcn.entity.User;
import com.offcn.exception.ExceptionCast;
import com.offcn.response.CommonCode;
import com.offcn.utils.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
public class Advice {

    StringRedisTemplate stringRedisTemplate;


    @Pointcut(value = "execution(public * com.offcn.consume..*.*(..))")
    public void auth(){}

    @Before("auth()")
    public  void doAuth(){
        //1.验证登录状态
        String uid = getTokenFormCookie();
        if (StringUtils.isEmpty(uid)){
            ExceptionCast.cast(CommonCode.UNAUTHENTICATED);
        }
        //取出cookie中的身份令牌
        String value = stringRedisTemplate.opsForValue().get(uid);
        User user = JSON.parseObject(value, User.class);
        if(user==null){
            ExceptionCast.cast(CommonCode.UNAUTHENTICATED);
        }
    }

    //取出cookie中的身份令牌
    private String getTokenFormCookie(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> map = CookieUtil.readCookie(request, "uid");
        if(map!=null && map.get("uid")!=null){
            String uid = map.get("uid");
            return uid;
        }
        return null;
    }

}
