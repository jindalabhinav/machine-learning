package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.VehicleType;
import com.scaler.parkinglot.repositories.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {

        return parkingSpot;
    }

    // TODO: use strategy pattern here to decide the allocation strategy
    public ParkingSpot allocateSpot(Long parkingLotId, VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot update(ParkingSpot parkingSpot){
        return parkingSpotRepository.update(parkingSpot);
    }
}
