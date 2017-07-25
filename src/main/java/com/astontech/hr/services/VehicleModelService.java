package com.astontech.hr.services;


import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleModel;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
public interface VehicleModelService {

    VehicleModel saveVehicleModel(VehicleModel vehicleModel);

    VehicleModel getVehicleModelById(Integer id);

    Iterable<VehicleModel> saveVehicleModelList(Iterable<VehicleModel> vehicleModelIterable);

    Iterable<VehicleModel> listAllVehicleModels();

    void deleteVehicleModelById(Integer id);

}
