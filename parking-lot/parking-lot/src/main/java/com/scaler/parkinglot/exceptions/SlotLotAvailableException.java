package com.scaler.parkinglot.exceptions;

import com.scaler.parkinglot.models.VehicleType;

public class SlotLotAvailableException extends RuntimeException {
    public SlotLotAvailableException(VehicleType vehicleType){
        super("Slot not available for type: " + vehicleType);
    }
}
