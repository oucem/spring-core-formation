package com.certification.springcoreformation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "manager", initMethod = "init")
    ServiceManager serviceManager(){
        return new ServiceManager();
    }

    void initialize(){
        System.err.println("inside test method");
    }
}
