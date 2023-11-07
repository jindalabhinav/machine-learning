package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.CreateTicketRequest;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ticket")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;
    @PostMapping
    public Ticket createTicket(@RequestBody CreateTicketRequest request) {
//        validate(request);
//        Ticket ticket = transform(request);
        return ticketService.createTicket(request);
    }
}
