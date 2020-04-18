package com.offcn.consume.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task {

    @Autowired
    private RedisTemplate redisTemplate;

    //定时每一秒增加17个令牌；
    @Scheduled(cron = "* * * * * ?")
    public void addToken(){
        int tokenNum =(int) redisTemplate.boundValueOps("token").get();
        //令牌桶总量为1000，令牌数量小于1000才增加，否则不增加
        if (tokenNum<1000){
            //增加17个令牌；
            tokenNum=tokenNum+17;
            //增加后令牌大于1000，多余的令牌丢弃，令牌最多1000
            if (tokenNum>1000){
                tokenNum=1000;
            }
            redisTemplate.boundValueOps("token").set(tokenNum);
        }
    }

}
