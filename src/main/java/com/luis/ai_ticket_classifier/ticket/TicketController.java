package com.luis.ai_ticket_classifier.ticket;

import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisRequest;
import com.luis.ai_ticket_classifier.ticket.dto.TicketAnalysisResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketAnalysisService ticketAnalysisService;


    @PostMapping("analyze")
    public TicketAnalysisResponse  analyze(
            @Valid
            @RequestBody
            TicketAnalysisRequest
            request
    ) {
        return ticketAnalysisService.analyze(request);
    }
}
