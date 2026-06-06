package com.luis.ai_ticket_classifier.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Primary
public class OpenAiClient implements AiClient {

    private final RestClient openAiRestClient;
    private final OpenAIProperties properties;
    private final ObjectMapper objectMapper;


    @Override
    public TicketAnalysisResponse analyzeTicket(String message) {
        try {
            Map<String, Object> body = Map.of(
                    "model", properties.model(),
                    "response_format", Map.of("type", "json_object"),
                    "messages", List.of(
                            Map.of("role", "system",
                            "content","""
                    "You are a support ticket classifier.
                    Return only valid JSON.
                    The json must have:
                      {
                      "category": "billing | technical | account | sales | other",
                      "priority": "low | medium | high | urgent",
                      "sentiment": "calm | confused | frustrated | angry",
                      "summary": "short summary",
                      "suggestedResponse": "professional response to the customer"
                      }"""
                    ),
                    Map.of(
                            "role", "user",
                            "content", message
                    )
            )
            );

            JsonNode response = openAiRestClient.post()
                    .uri("/chat/completions")
                    .body(body)
                    .retrieve()
                    .body(JsonNode.class);

            String content = response
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

            return objectMapper.readValue(content, TicketAnalysisResponse.class);
        } catch(Exception e) {
            throw new RuntimeException("Error analyzing ticket with AI", e);
        }
    }
}
