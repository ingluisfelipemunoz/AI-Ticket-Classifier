package com.luis.ai_ticket_classifier.ai;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ai.openai")
public record OpenAIProperties(
        String apiKey,
        String baseUrl,
        String model
) {
}
