package com.freek.imageai_m;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ImageAiMApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImageAiMApplication.class, args);
    }

}
