package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dtos.CreateParkingLotRequest;
import com.scaler.parkinglot.models.ParkingLot;
import com.scaler.parkinglot.services.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// Step 1 - Add RestController annotation, for spring to know that this is a controller class
@RequestMapping("/api/v1/parking-lot") // Step 2 - Map all the requests for this URL to this controller
@RestController
@AllArgsConstructor
public class ParkingLotController {
    private ParkingLotService parkingLotService;

    // Controllers are supposed to be very lean and aren't supposed to have logic,
    // but they're responsible for 2 things:
    // 1. Request validation
    // 2. Data Transformation

    // POST /api/v1/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    // GET /api/v1/parking-lot/{id}
    @GetMapping("/{id}") // Step 3 - Add method-level mapping
    public ParkingLot getParkingLot(@PathVariable("id") Long id) { // Step 4 - Add path variable mapping
        return ParkingLot.builder().id(id).build();
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() ==  null) {
            throw new RuntimeException("Invalid number of floors");
        }
    }

    private  ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }
}
