package com.certification.springcoreformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreFormationApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringCoreFormationApplication.class);

    public static void main(String[] args) {
        log.info("starting context {}" , SpringApplication.run(SpringCoreFormationApplication.class, args).getDisplayName());
    }
}
