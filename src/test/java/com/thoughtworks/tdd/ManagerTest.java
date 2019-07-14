package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    @Test
    public void should_parking_boy_list_has_one_when_add_parking_boy_given_a_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingLot parkingLotTwo = new ParkingLot();
        Manager manager = new Manager(parkingLotTwo);
        manager.addParkingBoy(parkingBoy);

        //when
        int actualSize = manager.getParkingBoys().size();

        //than
        Assertions.assertEquals(1, actualSize);

    }
}
