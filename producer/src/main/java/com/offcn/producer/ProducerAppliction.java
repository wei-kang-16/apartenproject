package com.offcn.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.offcn"})
public class ProducerAppliction {

    public static void main(String[] args) {
        SpringApplication.run(ProducerAppliction.class,args);
    }

}
