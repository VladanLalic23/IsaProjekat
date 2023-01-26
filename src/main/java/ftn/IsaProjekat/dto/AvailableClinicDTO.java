package ftn.IsaProjekat.dto;

public class AvailableClinicDTO {
    private Long clinicId;
	private String clinicName;
	private String clinicAddress;
	private double clinicAverageGrade;
    

    public AvailableClinicDTO() {
    }

    public AvailableClinicDTO(Long clinicId, String clinicName, String clinicAddress, double clinicAverageGrade) {
        this.clinicId = clinicId;
        this.clinicName = clinicName;
        this.clinicAddress = clinicAddress;
        this.clinicAverageGrade = clinicAverageGrade;
    }

    public Long getClinicId() {
        return this.clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public String getClinicName() {
        return this.clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getClinicAddress() {
        return this.clinicAddress;
    }

    public void setClinicAddress(String clinicAddress) {
        this.clinicAddress = clinicAddress;
    }

    public double getClinicAverageGrade() {
        return this.clinicAverageGrade;
    }

    public void setClinicAverageGrade(double clinicAverageGrade) {
        this.clinicAverageGrade = clinicAverageGrade;
    }

}
