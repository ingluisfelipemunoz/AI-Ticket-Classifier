package com.luis.ai_ticket_classifier;

import com.luis.ai_ticket_classifier.ai.OpenAIProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(OpenAIProperties.class)
public class AiTicketClassifierApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiTicketClassifierApplication.class, args);
	}

}
