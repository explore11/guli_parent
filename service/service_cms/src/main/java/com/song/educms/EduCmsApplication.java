package com.song.educms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/* *
 * @program: guli_parent
 * @description
 * @author: swq
 * @create: 2020-09-15 09:24
 **/
@SpringBootApplication
@ComponentScan("com.song")
@MapperScan("com.song.educms.mapper")
public class EduCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduCmsApplication.class, args);
    }
}
