package com.scaler.parkinglot.models;

import com.scaler.parkinglot.services.VehicleService;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Vehicle extends BaseModel {
    private String licenseNumber;
    private VehicleType vehicleType;
}
