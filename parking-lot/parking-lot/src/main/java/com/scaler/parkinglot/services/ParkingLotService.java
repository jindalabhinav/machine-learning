package com.scaler.parkinglot.services;

import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.models.ParkingSpot;
import com.scaler.parkinglot.repositories.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Tells spring that you have to create an object for this
@AllArgsConstructor
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLot create(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }
    public ParkingLot get(Long id) {
        return ParkingLot.builder().build();
    }
}
