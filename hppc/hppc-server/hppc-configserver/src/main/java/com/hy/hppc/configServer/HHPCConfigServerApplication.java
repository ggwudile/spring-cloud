package com.hy.hppc.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@EnableConfigServer
@SpringBootApplication
public class HHPCConfigServerApplication {

   public static void main(String[] args) {
        SpringApplication.run(HHPCConfigServerApplication.class, args);
    }
}