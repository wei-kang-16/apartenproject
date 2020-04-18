package com.offcn.consume.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "producer")
public interface ProducerClient {

    @GetMapping("/pro/get/{id}")
    public String findById(@PathVariable("id") String id);

}
