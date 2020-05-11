package com.certification.springcoreformation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("service")
public class ServiceManager implements InitializingBean {

    private int i = 0;

    public ServiceManager() {
    }

    public void init(){
        System.err.println("phase "+ incrementAndGet() +": inside init method inside bean definition");
    }

    @PostConstruct
    void postConstruct(){
        System.err.println("phase "+ incrementAndGet() +": inside postConstruct method inside bean definition");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("phase "+ incrementAndGet() +": inside afterPropertiesSet method inside bean definition");
    }

    private int incrementAndGet(){
        return i++;
    }
}
