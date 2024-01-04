package com.hurryclear.contentcalendar;

import com.hurryclear.contentcalendar.config.ContentCalendarProperties;
import com.hurryclear.contentcalendar.model.Content;
import com.hurryclear.contentcalendar.model.Status;
import com.hurryclear.contentcalendar.model.Type;
import com.hurryclear.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {

		SpringApplication.run(ContentCalendarApplication.class, args);
//		RestTemplate restTemplate = (RestTemplate) context.getBean("restTemplate");
//		System.out.println(restTemplate);
	}

	// write more code
	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			// insert some data into the database
			Content content = new Content(
					null,
					"Hello Chat GPT",
					"All about Chat GPT",
					Status.IDEA,
					Type.ARTICLE,
					LocalDateTime.now(),
					null,
					""
			);
			repository.save(content);
		};
	}
}
