package com.song.edugateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/* *
 * @program: guli_parent
 * @description 网关
 * @author: swq
 * @create: 2020-09-19 09:50
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.song"})
public class EduGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduGateWayApplication.class, args);
    }
}
