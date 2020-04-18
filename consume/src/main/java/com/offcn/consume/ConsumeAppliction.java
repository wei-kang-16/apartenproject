package com.offcn.consume;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
        import org.springframework.cloud.openfeign.EnableFeignClients;
        import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients//开启FeignClient，回去扫描带有FeignClient注解的接口，并生成代理对象
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.offcn"})
public class ConsumeAppliction {

    public static void main(String[] args) {
        SpringApplication.run(ConsumeAppliction.class,args);
    }

}
