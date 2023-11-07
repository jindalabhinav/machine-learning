package com.scaler.parkinglot.models;

import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
public class Payment extends BaseModel {
    private PaymentMode paymentMode;
    private Long amount;
    private PaymentStatus paymentStatus;
    private Date paymentTime;
}
