package com.certification.springcoreformation;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * This is a Small hack to avoid SSL validation in Spring RestTemplate
 * Good way is to use SSlContext with certificate import inside JVM with JSSE
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate initRestTemplateForPdfAsByteArrayAndSelfSignedHttps(HttpComponentsClientHttpRequestFactory httpClientFactory) {
        RestTemplate restTemplate = new RestTemplate(httpClientFactory);
        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory useApacheHttpClientWithSelfSignedSupport() {
        CloseableHttpClient httpClient = HttpClients.custom().setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        HttpComponentsClientHttpRequestFactory useApacheHttpClient = new HttpComponentsClientHttpRequestFactory();
        useApacheHttpClient.setHttpClient(httpClient);
        return useApacheHttpClient;
    }
}
