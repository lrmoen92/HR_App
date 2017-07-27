package com.astontech.hr.bootstrap;

import com.astontech.hr.domain.*;
import com.astontech.hr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logan.Moen on 7/12/2017.
 */
@Component
public class SeedData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ElementService elementService;

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        generateVehicleVehicleModelVehicleMake();
//        generateElementAndElementTypes();
//        generateEmployees();
    }

    private void generateElementAndElementTypes(){
        ElementType laptopType = new ElementType("Laptop");

        List<Element> laptopElementList = new ArrayList<>();
        laptopElementList.add(new Element("Acer"));
        laptopElementList.add(new Element("Dell"));
        laptopElementList.add(new Element("Samsung"));
        laptopElementList.add(new Element("Apple"));
        laptopElementList.add(new Element("Asus"));

        laptopType.setElementList(laptopElementList);

        elementTypeService.saveElementType(laptopType);

        ElementType desktopType = new ElementType("Desktop");

        List<Element> desktopElementList = new ArrayList<>();
        desktopElementList.add(new Element("Hewlet-Packard"));
        desktopElementList.add(new Element("Gateway"));
        desktopElementList.add(new Element("Dell"));
        desktopElementList.add(new Element("Apple"));
        desktopElementList.add(new Element("Toshiba"));

        desktopType.setElementList(desktopElementList);

        elementTypeService.saveElementType(desktopType);

        ElementType phoneType = new ElementType("Phone");

        List<Element> phoneElementList = new ArrayList<>();
        phoneElementList.add(new Element("Samsung"));
        phoneElementList.add(new Element("Apple"));
        phoneElementList.add(new Element("Google"));
        phoneElementList.add(new Element("HTC"));
        phoneElementList.add(new Element("LG"));

        phoneType.setElementList(phoneElementList);

        elementTypeService.saveElementType(phoneType);

        ElementType emailType = new ElementType("Email");

        List<Element> emailElementList = new ArrayList<>();
        emailElementList.add(new Element("Gmail"));
        emailElementList.add(new Element("Yahoo"));
        emailElementList.add(new Element("AOL"));
        emailElementList.add(new Element("Hotmail"));
        emailElementList.add(new Element("AstonTech"));

        emailType.setElementList(emailElementList);

        elementTypeService.saveElementType(emailType);
    }

    private void generateVehicleVehicleModelVehicleMake(){

        VehicleMake vmFord = vehicleMakeService.saveVehicleMake(new VehicleMake("Ford"));
        VehicleMake vmChevy = vehicleMakeService.saveVehicleMake(new VehicleMake("Chevy"));
        VehicleMake vmBuick = vehicleMakeService.saveVehicleMake(new VehicleMake("Buick"));

        VehicleModel vmRanger = vehicleModelService.saveVehicleModel(new VehicleModel("Ranger", vmFord));
        VehicleModel vmFocus = vehicleModelService.saveVehicleModel(new VehicleModel("Focus", vmFord));
        VehicleModel vmFusion = vehicleModelService.saveVehicleModel(new VehicleModel("Fusion", vmFord));
        VehicleModel vmF150 = vehicleModelService.saveVehicleModel(new VehicleModel("F150", vmFord));
        VehicleModel vmS10 = vehicleModelService.saveVehicleModel(new VehicleModel("S10", vmChevy));
        VehicleModel vmCamaro = vehicleModelService.saveVehicleModel(new VehicleModel("Camaro", vmChevy));
        VehicleModel vmSilverado = vehicleModelService.saveVehicleModel(new VehicleModel("Silverado", vmChevy));
        VehicleModel vmEquinox = vehicleModelService.saveVehicleModel(new VehicleModel("Equinox", vmChevy));
        VehicleModel vmCentury = vehicleModelService.saveVehicleModel(new VehicleModel("Century", vmBuick));
        VehicleModel vmLeSabre = vehicleModelService.saveVehicleModel(new VehicleModel("LeSabre", vmBuick));

        Vehicle vehicle1 = new Vehicle(1999, vmRanger,"FDE-394", "F112233746586");
        Vehicle vehicle2 = new Vehicle(2001, vmFocus,"DDI-990", "D343998059050");
        Vehicle vehicle3 = new Vehicle(2003, vmFusion,"667-FDF", "Z334455664534");
        Vehicle vehicle4 = new Vehicle(2005, vmF150,"ZZZ-111", "R122332123123");
        Vehicle vehicle5 = new Vehicle(2007, vmS10,"DFI-223", "C456567678789");
        Vehicle vehicle6 = new Vehicle(1997, vmCamaro,"114-UIU", "F776687656545");
        Vehicle vehicle7 = new Vehicle(2007, vmSilverado,"990-ZZR", "R223243746372");
        Vehicle vehicle8 = new Vehicle(2011, vmEquinox,"ILL-333", "P118492819218");
        Vehicle vehicle9 = new Vehicle(2011, vmCentury,"FRF-243", "F129381928567");
        Vehicle vehicle10 = new Vehicle(2003, vmLeSabre,"688-YUY", "T223100392192");

        vehicleService.saveVehicle(vehicle1);
        vehicleService.saveVehicle(vehicle2);
        vehicleService.saveVehicle(vehicle3);
        vehicleService.saveVehicle(vehicle4);
        vehicleService.saveVehicle(vehicle5);
        vehicleService.saveVehicle(vehicle6);
        vehicleService.saveVehicle(vehicle7);
        vehicleService.saveVehicle(vehicle8);
        vehicleService.saveVehicle(vehicle9);
        vehicleService.saveVehicle(vehicle10);
    }

    private void generateEmployees(){


        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Logan", "Moen", "Java Developer"));
        employeeList.add(new Employee("Andrew", "Warnke", "Boxer"));
        employeeList.add(new Employee("Chris", "Warnke", "Maintenance Engineer"));
        employeeList.add(new Employee("Brandon", "Koury", "Java Developer"));
        employeeList.add(new Employee("Paul", "Anderson", "Java Developer"));

        employeeService.save(employeeList);


    }
}
