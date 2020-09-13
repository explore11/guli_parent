package com.song.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-08-27 22:42
 **/
@SpringBootApplication
@ComponentScan("com.song")
public class EduServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduServiceApplication.class, args);
    }
}
