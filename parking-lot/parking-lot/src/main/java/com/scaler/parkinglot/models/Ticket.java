package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class Ticket extends BaseModel {
    private String vehicleNumber;
    private Vehicle vehicle;

    private Long parkingSpotId;
    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;

    private Long issuerId;
    private GateOperator issuedBy;

    private Long entryGateId;
    private Gate entryGate;
}
