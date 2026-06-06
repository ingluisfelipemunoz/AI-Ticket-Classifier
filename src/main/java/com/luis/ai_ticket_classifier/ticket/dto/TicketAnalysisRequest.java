package com.luis.ai_ticket_classifier.ticket.dto;

import jakarta.validation.constraints.NotBlank;

public record TicketAnalysisRequest(
        @NotBlank(message = "Message is required")
        String message
) {}
