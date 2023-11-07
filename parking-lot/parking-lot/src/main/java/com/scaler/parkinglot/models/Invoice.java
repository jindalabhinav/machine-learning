package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuperBuilder
public class Invoice extends BaseModel {
    private Date entryTime;
    private Date exitTime;
    private Ticket ticket;
    private Long amount;
    private List<Payment> payments = new ArrayList<>();
    private Gate exitGate;
}
