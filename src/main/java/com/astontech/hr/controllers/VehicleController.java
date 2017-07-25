package com.astontech.hr.controllers;

import com.astontech.hr.domain.VO.VehicleModelVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.domain.Vehicle;
import com.astontech.hr.domain.VehicleMake;
import com.astontech.hr.domain.VehicleModel;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.GET)
    public String getVehicle(Model model){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.POST)
    public String postVehicle(Model model, VehicleVO vehicleVO){
        model.addAttribute("vehicleVO", new VehicleVO());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        Vehicle postVehicle = new Vehicle(vehicleVO.getNewYear(), vehicleModelService.getVehicleModelById(vehicleVO.getNewModelId()), vehicleVO.getNewLicensePlate(), vehicleVO.getNewVin());
        vehicleService.saveVehicle(postVehicle);

        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehicle/list", method = RequestMethod.GET)
    public String getVehicleList(Model model){
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String editVehicle(Model model, @PathVariable int id){
        model.addAttribute("vehicleList", vehicleService.listAllVehicles());
        model.addAttribute("vehicleModelList", vehicleModelService.listAllVehicleModels());
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        model.addAttribute("year", vehicleService.getVehicleById(id).getYear());
        model.addAttribute("makeId", vehicleService.getVehicleById(id).getVehicleModel().getVehicleMake().getId());
        model.addAttribute("modelId", vehicleService.getVehicleById(id).getVehicleModel().getId());
        model.addAttribute("vin", vehicleService.getVehicleById(id).getVin());
        model.addAttribute("licensePlate", vehicleService.getVehicleById(id).getLicensePlate());
        return "/admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String updateVehicle(Vehicle vehicle, @RequestParam("vehicleModel.id") int modelId){
        vehicle.setVehicleModel(vehicleModelService.getVehicleModelById(modelId));
        vehicleService.updateVehicle(vehicle);
        return "redirect:/admin/vehicle/list/";
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String deleteVehicle(@PathVariable int id){
        vehicleService.deleteVehicleById(id);
        return "redirect:/admin/vehicle/list";
    }

    @RequestMapping(value = "/admin/vehicle/addModel", method = RequestMethod.GET)
    public String getAddModel(Model model){
        model.addAttribute("vehicleModelVO", new VehicleModelVO());

        return "/admin/vehicle/vehicle_model_add";
    }

    @RequestMapping(value = "/admin/vehicle/addModel", method = RequestMethod.POST)
    public String addModel(VehicleModelVO vehicleModelVO){
        VehicleModel newVehicleModel = new VehicleModel();
        VehicleMake newVehicleMake = new VehicleMake();

        newVehicleMake.setVehicleMakeName(vehicleModelVO.getNewVehicleMakeName());

            VehicleMake vm = vehicleMakeService.saveVehicleMake(newVehicleMake);

        if(!vehicleModelVO.getNewVehicleModelName().equals("")) {
            newVehicleModel.setVehicleModelName(vehicleModelVO.getNewVehicleModelName());
            newVehicleModel.setVehicleMake(vm);
            vehicleModelService.saveVehicleModel(newVehicleModel);
        }

        return "redirect:/admin/vehicle/";
    }

}
