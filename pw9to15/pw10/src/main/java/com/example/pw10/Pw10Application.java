package com.example.pw10;

import com.example.pw10.di.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Pw10Application {

    public static void main(String[] args) {
        SpringApplication.run(Pw10Application.class, args);
        Work worker = new Work();
        worker.work("middle");
    }
}
