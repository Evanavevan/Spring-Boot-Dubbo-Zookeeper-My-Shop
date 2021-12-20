package com.evan.myshop.service.redis.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(scanBasePackages = "com.evan.myshop")
@EnableHystrix
@EnableHystrixDashboard
public class MyShopServiceUserConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceUserConsumerApplication.class, args);
    }
}