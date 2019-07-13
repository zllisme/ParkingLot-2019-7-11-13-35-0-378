package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingLot parkingLot;

    private String message;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Ticket park(Car car) {
        return this.parkingLot.park(car);
    }

    public Car fetch(Ticket ticket) {
        if(parkingLot.getCar(ticket) == null) {
            this.message = "Unrecognized parking ticket.";
        }
        return this.parkingLot.getCar(ticket);
    }


    public String getMessage() {
        return this.message;
    }
}
