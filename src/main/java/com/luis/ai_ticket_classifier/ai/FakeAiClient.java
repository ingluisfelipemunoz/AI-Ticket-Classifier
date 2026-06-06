package com.luis.ai_ticket_classifier.ai;

import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisResponse;
import org.springframework.stereotype.Component;

@Component
public class FakeAiClient implements AiClient {
    @Override
    public TicketAnalysisResponse analyzeTicket(String message) {
        return new TicketAnalysisResponse(
                "billing",
                "high",
                "angry",
                "Customer reports a billing issue and expects urgent help.",
                "We're sorry for the inconvenience. We'll review your case immediately and help resolve the issue"
        );
    }
}
