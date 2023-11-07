package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.VehicleType;
import lombok.Getter;

@Getter
public class CreateTicketRequest {
    private String vehicleNumber;
    private Long parkingSpotId;
    private Long parkingLotId;
    private Long issuerId;
    private Long entryGateId;
    private VehicleType vehicleType;
}
