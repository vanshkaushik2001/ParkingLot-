package com.parkinglot.parking;

import com.parkinglot.vehicle.Vehicle;
import lombok.Setter;

import java.util.List;


public class NaturalOrderParking extends ParkingStrategy{

    public ParkingSpace park(List<ParkingSpace> availableSpaces){
        return availableSpaces.get(0);
    }
}
