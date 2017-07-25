package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleId")
    private Integer id;

    @Version
    private Integer version;

    private String licensePlate;
    private String vin;
    private Integer year;

    @ManyToOne
    private VehicleModel vehicleModel;

    public Vehicle(){}
    public Vehicle(Integer year, String licensePlate, String vin){
        this.setYear(year);
        this.setLicensePlate(licensePlate);
        this.setVin(vin);
    }
    public Vehicle(Integer year, VehicleModel vehicleModel, String licensePlate, String vin){
        this.setYear(year);
        this.setVehicleModel(vehicleModel);
        this.setLicensePlate(licensePlate);
        this.setVin(vin);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
}
