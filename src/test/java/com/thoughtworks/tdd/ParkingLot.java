package com.thoughtworks.tdd;

public class ParkingLot {
    private Car car;

    public Car getCar() {
        return car;
    }

    public Ticket park(Car car) {
        this.car = car;
        return new Ticket();
    }
}
