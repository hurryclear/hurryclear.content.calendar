package com.hurryclear.contentcalendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // in this clss there are one or more @Bean methods
public class WebConfig {

    @Bean // add to methode when you want to make this methode a bean
    public RestTemplate restTemplate() {

        return new RestTemplateBuilder().build();

    }
}
