package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {

        for(Vehicle v : vehicleRepository.findAll()){
            if(v.getVin().equals(vehicle.getVin())){
                return vehicleRepository.findOne(v.getId());
            }
        }

        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle getVehicleById(Integer id) {
        return vehicleRepository.findOne(id);
    }

    @Override
    public Iterable<Vehicle> saveVehicleList(Iterable<Vehicle> vehicleIterable) {
        return vehicleRepository.save(vehicleIterable);
    }

    @Override
    public Iterable<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public void deleteVehicleById(Integer id) {
        vehicleRepository.delete(id);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }
}
