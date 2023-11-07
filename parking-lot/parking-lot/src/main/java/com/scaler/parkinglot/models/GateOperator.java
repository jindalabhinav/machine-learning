package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class GateOperator extends BaseModel {
    private String name;
    private Number phoneNumber;
    private String email;
}
