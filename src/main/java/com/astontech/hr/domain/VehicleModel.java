package com.astontech.hr.domain;

import javax.persistence.*;

/**
 * Created by Logan.Moen on 7/14/2017.
 */

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VehicleModelId")
    private Integer id;

    @Version
    private Integer version;

    private String vehicleModelName;

    @ManyToOne
    private VehicleMake vehicleMake;

    public VehicleModel(){}
    public VehicleModel(String vehicleModelName){
        this.setVehicleModelName(vehicleModelName);
    }
    public VehicleModel(String vehicleModelName, VehicleMake vehicleMake){
        this.setVehicleModelName(vehicleModelName);
        this.setVehicleMake(vehicleMake);
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

    public String getVehicleModelName() {
        return vehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        this.vehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
}
