package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Ticket;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketRepository {
    List<Ticket> tickets = new ArrayList<>();

    public Ticket save(Ticket ticket) {
        tickets.add(ticket);
        return ticket;
    }
}
