package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.AppointmentStatus;
import ftn.IsaProjekat.model.clinic.TimeInterval;

public class DonorAppointmentDTO {

    private long id;		
	private long staffId;
	private AppointmentStatus status;
	private int loyaltyPoints;
	private TimeInterval timeInterval;


    public DonorAppointmentDTO() {
    }

    public DonorAppointmentDTO(long id, long staffId, AppointmentStatus status, int loyaltyPoints, TimeInterval timeInterval) {
        this.id = id;
        this.staffId = staffId;
        this.status = status;
        this.loyaltyPoints = loyaltyPoints;
        this.timeInterval = timeInterval;
    }

    public DonorAppointmentDTO(Appointment appointment) {
        this.id = appointment.getId();
        this.staffId = appointment.getStaffId();
        this.status = appointment.getStatus();
        this.loyaltyPoints = appointment.getLoyaltyPoints();
        this.timeInterval = appointment.getTimeInterval();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStaffId() {
        return this.staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public AppointmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public TimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    
}
