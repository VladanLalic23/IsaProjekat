package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.clinic.Clinic;

public class ClinicProfileDTO {

    private String name;
    private double averageGrade;

    public ClinicProfileDTO() {
    }

    public ClinicProfileDTO(String name, float averageGrade) {
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public ClinicProfileDTO(Clinic clinic) {
        this.name = clinic.getName();
        this.averageGrade = clinic.getAverageGrade();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

}
