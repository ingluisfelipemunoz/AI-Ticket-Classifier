package com.luis.ai_ticket_classifier.ai;

import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisResponse;

public interface AiClient {
    TicketAnalysisResponse analyzeTicket(String message);
}
