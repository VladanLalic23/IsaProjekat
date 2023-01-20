package ftn.IsaProjekat.dto;

import java.util.Date;

import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.AppointmentStatus;

public class AppointmentDTO {
	private long appointmentId;
    private long clinicId;
	private long staffId;
	private long donorId;
	private String donorName;
	private String donorSurname;
	private String clinicName;
	AppointmentStatus status;
	private Date startDate;
	private Date endDate;
    

    public AppointmentDTO() {
    }


    public long getClinicId() {
        return this.clinicId;
    }

    public void setClinicId(long clinicId) {
        this.clinicId = clinicId;
    }



    public AppointmentDTO(long appointmentId, long staffId, long donorId, String donorName, String donorSurname, String clinicName, AppointmentStatus status, Date startDate, Date endDate, long clinicId) {
        this.appointmentId = appointmentId;
        this.staffId = staffId;
        this.donorId = donorId;
        this.donorName = donorName;
        this.donorSurname = donorSurname;
        this.clinicName = clinicName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clinicId=clinicId;
    }

    public AppointmentDTO(Appointment appointment) {
		this.appointmentId = appointment.getId();
		this.staffId = appointment.getStaffId();
		this.donorId = appointment.getDonor().getId();
		this.donorName = appointment.getDonor().getName();
		this.donorSurname = appointment.getDonor().getSurname();
		this.clinicName = appointment.getClinic().getName();
		this.status = appointment.getStatus();
		this.startDate = appointment.getTimeInterval().getStartTime();
		this.endDate = appointment.getTimeInterval().getEndTime();
        this.clinicId=appointment.getClinic().getId();
    }


    public AppointmentDTO(long appointmentId, long staffId, String clinicName, AppointmentStatus status, 
    Date startDate, Date endDate) {
    this.appointmentId = appointmentId;
    this.staffId = staffId;
    this.clinicName = clinicName;
    this.status = status;
    this.startDate = startDate;
    this.endDate = endDate;
}

    public long getAppointmentId() {
        return this.appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public long getStaffId() {
        return this.staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public long getDonorId() {
        return this.donorId;
    }

    public void setDonorId(long donorId) {
        this.donorId = donorId;
    }

    public String getDonorName() {
        return this.donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getDonorSurname() {
        return this.donorSurname;
    }

    public void setDonorSurname(String donorSurname) {
        this.donorSurname = donorSurname;
    }

    public String getClinicName() {
        return this.clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public AppointmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
}
