package com.leyou.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.leyou.demo.mapper")
public class LyItemServerApp {
    public static void main(String[] args) {
        SpringApplication.run(LyItemServerApp.class);
    }
}
