package ftn.IsaProjekat.dto;

import java.util.Date;

public class AppointmentSchedulingEmailDTO {

	private String donorEmail;
	private String clinicName;
	private String clinicAdress;
	private Date startTime;

	
	public AppointmentSchedulingEmailDTO() {
		
	}
	

	public AppointmentSchedulingEmailDTO(String donorEmail, String clinicName, String clinicAdress, Date startTime) {
		this.donorEmail = donorEmail;
		this.clinicName = clinicName;
		this.clinicAdress = clinicAdress;
		this.startTime = startTime;
	}

	public String getDonorEmail() {
		return this.donorEmail;
	}

	public void setDonorEmail(String donorEmail) {
		this.donorEmail = donorEmail;
	}

	public String getClinicName() {
		return this.clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinicAdress() {
		return this.clinicAdress;
	}

	public void setClinicAdress(String clinicAdress) {
		this.clinicAdress = clinicAdress;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

}