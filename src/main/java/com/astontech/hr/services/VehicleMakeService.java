package com.astontech.hr.services;


import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
public interface VehicleMakeService {

    VehicleMake saveVehicleMake(VehicleMake vehicleMake);

    VehicleMake getVehicleMakeById(Integer id);

    Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable);

    Iterable<VehicleMake> listAllVehicleMakes();

    void deleteVehicleMakeById(Integer id);

}
