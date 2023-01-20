package ftn.IsaProjekat.dto;

import java.util.Date;

import ftn.IsaProjekat.model.clinic.Appointment;

public class AvailableAppointmentDTO {
    private Long appointmentId;
	private int loyaltyPoints;
	private Date startTime;
	private Date endTime;
	private double price;


	public AvailableAppointmentDTO() {
	}

	public Long getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getLoyaltyPoints() {
		return this.loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}





    public AvailableAppointmentDTO(Long appointmentId, int loyaltyPoints, Date startTime, Date endTime) {
		super();
		this.appointmentId = appointmentId;
		this.loyaltyPoints = loyaltyPoints;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public AvailableAppointmentDTO(Appointment appointment) {
		this.appointmentId = appointment.getId();
		this.loyaltyPoints = appointment.getLoyaltyPoints();
		this.startTime = appointment.getTimeInterval().getStartTime();
		this.endTime = appointment.getTimeInterval().getEndTime();
		
	}
    
}
