package com.thoughtworks.tdd;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int capacity = 10;
    private Map<Ticket, Car> cars = new HashMap<>();
    private String errorMessage;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Car getCar(Ticket ticket) {
        if(ticket == null) {
            errorMessage = "Please provide your parking ticket.";
            return null;
        }
        if(!cars.containsKey(ticket)) {
            errorMessage = "Unrecognized parking ticket.";
            return null;
        }
        return cars.remove(ticket);
    }

    public Ticket park(Car car) {
        if(cars.size() == capacity) {
            errorMessage = "Not enough position.";
            return null;
        }
        if(this.cars.containsValue(car) || car == null) {
            return null;
        }
        Ticket ticket = new Ticket();
        this.cars.put(ticket, car);
        return ticket;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
