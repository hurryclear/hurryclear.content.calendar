package com.hurryclear.contentcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {

		SpringApplication.run(ContentCalendarApplication.class, args);
//		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
//		System.out.println(restTemplate);
	}

	// write more code
}
