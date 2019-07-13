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

    @Test
    public void should_return_cars_when_fetch_cars_given_tickets_by_parking_the_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car carTwo = new Car();
        Ticket ticket = parkingBoy.park(car);
        Ticket ticketTwo = parkingBoy.park(carTwo);

        //when
        Car fetchedCar = parkingBoy.fetch(ticket);
        Car fetchedCarTwo = parkingBoy.fetch(ticketTwo);

        //than
        Assertions.assertSame(car, fetchedCar);
        Assertions.assertSame(carTwo, fetchedCarTwo);

    }
}
