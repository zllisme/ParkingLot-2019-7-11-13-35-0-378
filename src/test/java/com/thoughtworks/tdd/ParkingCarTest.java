package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingCarTest {

    @Test
    public void should_return_car_when_fetch_car_given_ticket_by_parking_the_car() {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket ticket = parkingBoy.park(car);
        Car fetchedCar = parkingBoy.fetch(ticket);
        Assertions.assertSame(car, fetchedCar);
    }
}
