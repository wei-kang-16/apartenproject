package com.offcn.consume.controller;

import com.offcn.consume.service.ConsumeService;
import com.offcn.response.QueryResponseResult;
import com.offcn.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumeController {

    @Autowired
    private ConsumeService consumeService;

    @GetMapping("/getPro/{id}")
    public QueryResponseResult getPro(@PathVariable("id") String id){
        System.out.println("这是消费者");
        return consumeService.getPro(id);
    }

}
