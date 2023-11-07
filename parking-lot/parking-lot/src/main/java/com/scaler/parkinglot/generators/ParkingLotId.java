package com.scaler.parkinglot.generators;

import java.util.concurrent.atomic.AtomicLong;

public class ParkingLotId {
    private static AtomicLong id = new AtomicLong();

    public static Long getNextId() {
        return id.getAndIncrement();
    }
}
