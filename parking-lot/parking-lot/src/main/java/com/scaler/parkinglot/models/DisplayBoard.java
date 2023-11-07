package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuperBuilder
public class DisplayBoard extends BaseModel {
    private Long floorId;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();
}
