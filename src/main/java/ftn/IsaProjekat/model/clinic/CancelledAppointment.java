package ftn.IsaProjekat.model.clinic;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ftn.IsaProjekat.model.users.Donor;

import javax.persistence.*;

@Entity
@Table(name = "cancelled_appointments")
public class CancelledAppointment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Donor donor;
	
	@Column(name = "staff_id", nullable = false)
	private long staffId;
	
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;
	
	@Column(name = "loyaltyPoints", nullable =false)
	private int loyaltyPoints;
	
	@Embedded
	private TimeInterval timeInterval;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
	private Clinic clinic;
	
	public CancelledAppointment() {
		
	}

	public CancelledAppointment(long id, Donor donor, long staffId, AppointmentStatus status, int loyaltyPoints, TimeInterval timeInterval, Clinic clinic) {
		super();
		this.id = id;
		this.donor = donor;
		this.staffId = staffId;
		this.status = status;
		this.loyaltyPoints = loyaltyPoints;
		this.timeInterval = timeInterval;
		this.clinic = clinic;
	}

	public CancelledAppointment(Appointment appointment) {
		super();
		this.donor = appointment.getDonor();
		this.staffId = appointment.getStaffId();
		this.status = appointment.getStatus();
		this.loyaltyPoints = appointment.getLoyaltyPoints();
		this.timeInterval = appointment.getTimeInterval();
		this.clinic = appointment.getClinic();
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Donor getDonor() {
		return this.donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
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

	public Clinic getClinic() {
		return this.clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	
}