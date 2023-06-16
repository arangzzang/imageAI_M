package com.freek.imageai_m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableWebMvc
//@ComponentScan
//@Configuration
//@EnableAutoConfiguration
public class ImageAiMApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageAiMApplication.class, args);
    }

}
