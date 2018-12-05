package com.hy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //开启断路器功能，进行容错管理
@EnableHystrixDashboard //开启断路器仪表盘
public class ScCustomerAApplication {

    @LoadBalanced //开启负载均衡客户端
    @Bean //注册一个具有容错功能的RestTemplate
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ScCustomerAApplication.class, args);
    }
}

