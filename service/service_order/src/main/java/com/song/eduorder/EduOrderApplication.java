package com.song.eduorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-17 22:53
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.song"})
@EnableFeignClients
@MapperScan("com.song.eduorder.mapper")
public class EduOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduOrderApplication.class, args);
    }
}
