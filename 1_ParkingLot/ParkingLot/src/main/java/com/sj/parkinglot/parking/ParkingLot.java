package com.parkinglot.parking;

import com.parkinglot.admin.Address;
import com.parkinglot.vehicle.Vehicle;
import com.parkinglot.vehicle.VehicleType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ParkingLot
{
    private String pLotId;
    private List<Floor> floorList;
    private List<EntryGate> entries;
    private List<ExitGate> exits;
    private Address address;
    private ParkingStrategy pStrategy;


    public static ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot(){
        pLotId= UUID.randomUUID().toString();
        floorList = new ArrayList<>();
        entries= new ArrayList<>();
        exits= new ArrayList<>();
    }

    public boolean isParkingSpaceAvailable(VehicleType vType)
    {
        for (Floor floor : floorList) {
            return floor.canParkVehicle(vType);
        }
        return false;
    }
    public ParkingSpace findParkingSpace(Vehicle v)
    {
        for (Floor floor : floorList) {
            return floor.getSpace(v);
        }
        return null;
    }

}
