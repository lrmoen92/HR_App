package com.astontech.hr.services;


import com.astontech.hr.domain.Vehicle;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Integer id);

    Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable);

    Iterable<Vehicle> listAllVehicles();

    void deleteVehicleById(Integer id);

    Vehicle updateVehicle(Vehicle vehicle);

}
