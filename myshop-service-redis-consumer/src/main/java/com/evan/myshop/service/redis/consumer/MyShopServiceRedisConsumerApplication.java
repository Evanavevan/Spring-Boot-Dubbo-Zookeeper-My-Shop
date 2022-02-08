package com.evan.myshop.service.redis.consumer;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication(scanBasePackages = "com.evan.myshop")
@EnableHystrix
@EnableHystrixDashboard
public class MyShopServiceRedisConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyShopServiceRedisConsumerApplication.class, args);
        Main.main(args);
    }
}
