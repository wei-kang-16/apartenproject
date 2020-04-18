package com.offcn.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
public class ProController {

    @GetMapping("/get/{id}")
    public String findById(@PathVariable("id") String id){

        return "这是生产者"+id;
    }

}
