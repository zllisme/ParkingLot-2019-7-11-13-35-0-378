package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<Ticket, Car> cars = new HashMap<>();

    public Car getCar(Ticket ticket) {
        return cars.remove(ticket);
    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        this.cars.put(ticket, car);
        return ticket;
    }
}
