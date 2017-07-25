package com.astontech.hr.domain.VO;

/**
 * Created by Logan.Moen on 7/14/2017.
 */
public class VehicleVO {

    private String newVin;
    private String newLicensePlate;
    private Integer newYear;
    private Integer newModelId;
    private Integer newMakeId;


    public String getNewVin() {
        return newVin;
    }

    public void setNewVin(String newVin) {
        this.newVin = newVin;
    }

    public String getNewLicensePlate() {
        return newLicensePlate;
    }

    public void setNewLicensePlate(String newLicensePlate) {
        this.newLicensePlate = newLicensePlate;
    }

    public Integer getNewYear() {
        return newYear;
    }

    public void setNewYear(Integer newYear) {
        this.newYear = newYear;
    }

    public Integer getNewModelId() {
        return newModelId;
    }

    public void setNewModelId(Integer newModelId) {
        this.newModelId = newModelId;
    }

    public Integer getNewMakeId() {
        return newMakeId;
    }

    public void setNewMakeId(Integer newMakeId) {
        this.newMakeId = newMakeId;
    }
}
