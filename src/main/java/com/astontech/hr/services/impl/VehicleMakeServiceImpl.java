package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.repositories.VehicleMakeRepository;
import com.astontech.hr.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
@Service
public class VehicleMakeServiceImpl implements VehicleMakeService{

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    @Override
    public VehicleMake saveVehicleMake(VehicleMake vehicleMake) {
        for(VehicleMake vm : vehicleMakeRepository.findAll()){
            if(vm.getVehicleMakeName().equals(vehicleMake.getVehicleMakeName())){
                return vehicleMakeRepository.findOne(vm.getId());
            }
        }

        return vehicleMakeRepository.save(vehicleMake);
    }

    @Override
    public VehicleMake getVehicleMakeById(Integer id) {
        return vehicleMakeRepository.findOne(id);
    }

    @Override
    public Iterable<VehicleMake> saveVehicleMakeList(Iterable<VehicleMake> vehicleMakeIterable) {
        return vehicleMakeRepository.save(vehicleMakeIterable);
    }

    @Override
    public Iterable<VehicleMake> listAllVehicleMakes() {
        return vehicleMakeRepository.findAll();
    }

    @Override
    public void deleteVehicleMakeById(Integer id) {
        vehicleMakeRepository.delete(id);
    }
}
