package com.scaler.parkinglot.dtos;

import com.scaler.parkinglot.models.DisplayBoard;
import com.scaler.parkinglot.models.Gate;
import com.scaler.parkinglot.models.ParkingFloor;
import com.scaler.parkinglot.models.ParkingLot;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// This is similar to the ParkingLot Model (the Entity model) but not same as we don't expect the user to pass
// all the fields required by that Model. We instead create this DTO which simplifies the
// request and makes out API simpler
@Getter
public class CreateParkingLotRequest {
    private String name;
    private String address;
    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloor;
    private Integer numberOfEntryGates;
    private Integer numberOfExitGates;

    public ParkingLot toParkingLot() {
        var parkingFloors = Collections.nCopies(numberOfFloors, ParkingFloor.builder().build());


        return ParkingLot.builder().build();
    }
}
