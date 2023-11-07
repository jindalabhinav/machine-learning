package com.scaler.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingFloorId {
    private static AtomicLong idCounter = new AtomicLong();

    public static Long getNextId() {
        return idCounter.getAndIncrement();
    }
}
