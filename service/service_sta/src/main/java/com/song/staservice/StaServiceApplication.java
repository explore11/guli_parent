package com.song.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-18 18:31
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.song"})
@MapperScan("com.song.staservice.mapper")
@EnableScheduling
public class StaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StaServiceApplication.class, args);
    }
}
