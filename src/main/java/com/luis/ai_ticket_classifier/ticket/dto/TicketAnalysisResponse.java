package com.luis.ai_ticket_classifier.ticket.dto;

public record TicketAnalysisResponse(
        String category,
        String priority,
        String sentiment,
        String summary,
        String suggestedResponse
) {
}
