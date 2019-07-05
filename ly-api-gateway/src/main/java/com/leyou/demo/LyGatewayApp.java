package com.leyou.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author 孙启超
 */
@SpringBootApplication
//@EnableDiscoveryClient
@EnableZuulProxy
public class LyGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(LyGatewayApp.class);
    }
}
