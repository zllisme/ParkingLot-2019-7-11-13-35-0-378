package com.thoughtworks.tdd;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartParkingCarTest {

    @Test
    void should_second_parking_lot_has_two_car_when_park_car_given_less_car_into_second_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingLot parkingLotTwo = new ParkingLot();
        parkingLot.getCars().put(new Ticket(), new Car());
        parkingLot.getCars().put(new Ticket(), new Car());
        parkingLotTwo.getCars().put(new Ticket(), new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.addParkingLot(parkingLotTwo);
        //when
        smartParkingBoy.park(new Car());

        //than
        Assertions.assertEquals(2, parkingLotTwo.getCars().size());

    }

    @Test
    void should_not_return_ticket_when_park_car_but_parking_lot_has_no_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            smartParkingBoy.park(car);
        }

        //when
        Car  extraCar = new Car();
        Ticket ticket = smartParkingBoy.park(extraCar);

        //than
        Assertions.assertNull(ticket);
    }

    @Test
    public void should_not_return_ticket_when_park_car_given_null_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = null;

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //than
        Assertions.assertNull(ticket);
    }

    @Test
    public void should_not_return_ticket_when_park_car_given_used_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        Car car = new Car();
        smartParkingBoy.park(car);

        //when
        Ticket ticket = smartParkingBoy.park(car);

        //than
        Assertions.assertNull(ticket);

    }

    @Test
    public void should_get_error_message_when_park_car_has_no_position() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        for (int i = 0; i < 10; i++) {
            Car car = new Car();
            smartParkingBoy.park(car);
        }

        //when
        Car extraCar = new Car();
        smartParkingBoy.park(extraCar);
        String errorMessage = smartParkingBoy.queryErrorMessage();

        //than
        MatcherAssert.assertThat(errorMessage, CoreMatchers.is("Not enough position."));

    }

}
