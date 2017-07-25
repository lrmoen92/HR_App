package com.astontech.hr.services.impl;

import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.repositories.VehicleModelRepository;
import com.astontech.hr.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
@Service
public class VehicleModelServiceImpl implements VehicleModelService{

    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    @Override
    public VehicleModel saveVehicleModel(VehicleModel vehicleModel) {
        for(VehicleModel vm : vehicleModelRepository.findAll()){
            if(vm.getVehicleModelName().equals(vehicleModel.getVehicleModelName())){
                return vehicleModelRepository.findOne(vm.getId());
            }
        }

        return vehicleModelRepository.save(vehicleModel);
    }

    @Override
    public VehicleModel getVehicleModelById(Integer id) {
        return vehicleModelRepository.findOne(id);
    }

    @Override
    public Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable) {
        return vehicleModelRepository.save(vehicleModelIterable);
    }

    @Override
    public Iterable<VehicleModel> listAllVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    @Override
    public void deleteVehicleModelById(Integer id) {
        vehicleModelRepository.delete(id);
    }
}
