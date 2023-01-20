package ftn.IsaProjekat.model.clinic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import ftn.IsaProjekat.model.users.Donor;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "staff_id", nullable = false)
	private long staffId;

    @Embedded
    private TimeInterval timeInterval;

    @Column
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,optional = true)
    private Donor donor;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Clinic clinic;

    @Column(name = "loyaltyPoints", nullable =false)
	private int loyaltyPoints;

    public Appointment() {
    }


    public Appointment(long id, long staffId, TimeInterval timeInterval, AppointmentStatus status, Donor donor, Clinic clinic, int loyaltyPoints) {
        super();
        this.id = id;
        this.staffId = staffId;
        this.timeInterval = timeInterval;
        this.status = status;
        this.donor = donor;
        this.clinic = clinic;
        this.loyaltyPoints = loyaltyPoints;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public TimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public AppointmentStatus getStatus() {
        return this.status;
    }


    public long getStaffId() {
        return this.staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }

    public Donor getDonor() {
        return this.donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Clinic getClinic() {
        return this.clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

}