package com.example.pw10;

import com.example.pw10.di.BeanConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Work {
    private Programmer worker;
    private ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

    public void work(String w) {
        this.worker = context.getBean(w, Programmer.class);
        worker.doWork();
    }
}
