package com.certification.springcoreformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringCoreFormationApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringCoreFormationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreFormationApplication.class, args);
    }

    /**
     * Replace this bean the the service layer that calls RestTemplate
     * @param restTemplate
     * @return
     */
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args ->
                log.info("response from ssl protected url is {}",
                        restTemplate
                                .getForEntity("https://gturnquist-quoters.cfapps.io/api/random",
                                        String.class)
                                .getBody());
    }
}
