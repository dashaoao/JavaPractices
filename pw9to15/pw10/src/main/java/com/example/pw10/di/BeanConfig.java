package com.example.pw10.di;

import com.example.pw10.Programmer;
import com.example.pw10.Work;
import com.example.pw10.di.components.Junior;
import com.example.pw10.di.components.Middle;
import com.example.pw10.di.components.Senior;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

    @Primary
    @Bean(name = "junior")
    public Programmer junior() {
        return new Junior();
    }

    @Bean(name = "middle")
    public Programmer middle() {
        return new Middle();
    }

    @Bean(name = "senior")
    public Programmer senior() {
        return new Senior();
    }
}
