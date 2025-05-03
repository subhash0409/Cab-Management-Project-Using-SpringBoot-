package com.Cab_Management.demo.Rides;

public enum CabTypes {
    NORMAL(100),
    STANDARD(200),
    PREMIUM(500);

    public final int kmCharges;

    CabTypes(int kmCharges){
        this.kmCharges = kmCharges;
    }
}
