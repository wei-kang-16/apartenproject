package com.offcn.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.offcn"})
public class LoginAppliction {

    public static void main(String[] args) {
        SpringApplication.run(LoginAppliction.class,args);
    }

}
