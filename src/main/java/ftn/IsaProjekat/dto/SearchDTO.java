package ftn.IsaProjekat.dto;

import java.util.Date;

public class SearchDTO {
    private Date  appointmentTime;
	private Long clinicId;
	private Long donorId;

    public SearchDTO() {
    }

    public SearchDTO(Date appointmentTime, Long clinicId, Long donorId) {
        this.appointmentTime = appointmentTime;
        this.clinicId = clinicId;
        this.donorId = donorId;
    }

    public Date getAppointmentTime() {
        return this.appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Long getClinicId() {
        return this.clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
    }

    public Long getDonorId() {
        return this.donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    
}
