package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.Vehicle;
import com.scaler.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle
                .builder()
                .licenseNumber(vehicleNumber)
                .vehicleType(vehicleType)
                .build();
        // We need to create a VehicleRepository here
    }
}
