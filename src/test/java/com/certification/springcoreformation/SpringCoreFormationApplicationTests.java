package com.certification.springcoreformation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class SpringCoreFormationApplicationTests {

    @Autowired
    AnnotationConfigApplicationContext appCtx;

    @Test
    void contextLoads() {
        for (String bean:appCtx.getBeanDefinitionNames()) {
            System.err.println(bean);
        }
    }
}
