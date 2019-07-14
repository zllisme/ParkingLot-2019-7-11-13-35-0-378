package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys;

    public Manager(ParkingLot parkingLot) {
        super(parkingLot);
        this.parkingBoys = new ArrayList<>();
    }

    public Manager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = new ArrayList<>();
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public void addParkingBoys(List<ParkingBoy> parkingBoysToADD) {
        parkingBoys.addAll(parkingBoysToADD);
    }

    public List<ParkingBoy> getParkingBoys() {
        return parkingBoys;
    }

    public void specifyParkingBoyPark(ParkingBoy parkingBoy, Car car) {
        if(parkingBoys.contains(parkingBoy)) {
            parkingBoy.park(car);
        }
    }

    public void specifyParkingBoyFetch(ParkingBoy parkingBoy, Ticket ticket) {
        if(parkingBoys.contains(parkingBoy)) {
            parkingBoy.fetch(ticket);
        }
    }
}
