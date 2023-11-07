package com.scaler.parkinglot.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private List<ParkingFloor> floor = new ArrayList<>();
    private List<Gate> entryGates = new ArrayList<>();
    private List<Gate> exitGates = new ArrayList<>();
    private DisplayBoard displayBoard;
}
