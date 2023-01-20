package ftn.IsaProjekat.dto;

import java.util.Date;

public class AppointmentSearchDTO {
	private Date  appointmentTime;
	private long donorId;
	
	public AppointmentSearchDTO() {
		
	}

	public AppointmentSearchDTO(Date appointmentTime, long donorId) {
		this.appointmentTime = appointmentTime;
		this.donorId = donorId;
	}


	public long getDonorId() {
		return this.donorId;
	}

	public void setDonorId(long donorId) {
		this.donorId = donorId;
	}


	public Date getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Date appointmenTime) {
		this.appointmentTime = appointmenTime;
	}


}