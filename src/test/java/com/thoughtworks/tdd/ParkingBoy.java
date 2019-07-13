package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        return this.parkingLot.getCar(ticket);
    }


    public String queryErrorMessage() {
        return parkingLot.getErrorMessage();
    }
}
