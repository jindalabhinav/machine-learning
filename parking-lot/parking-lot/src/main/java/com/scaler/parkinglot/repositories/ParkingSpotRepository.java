package com.scaler.parkinglot.repositories;


import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.models.SpotStatus;
import com.scaler.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ParkingSpotRepository {
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType vehicleType) {
        for (var parkingSpot: parkingSpots) {
            if (parkingSpot.getSpotStatus() == SpotStatus.AVAILABLE && parkingSpot.getVehicleType() == vehicleType)
                return parkingSpot;
        }
        return null;
    }

    public ParkingSpot update(ParkingSpot parkingSpot) {
        return parkingSpot;
    }
}
