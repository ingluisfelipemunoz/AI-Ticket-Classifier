package com.luis.ai_ticket_classifier.ticket;

import com.luis.ai_ticket_classifier.ai.AiClient;
import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisRequest;
import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketAnalysisService {

    private final AiClient aiClient;

    public TicketAnalysisResponse analyze(@Valid TicketAnalysisRequest request) {
        return aiClient.analyzeTicket(request.message());
    }
}
