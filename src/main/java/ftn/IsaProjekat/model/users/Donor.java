package ftn.IsaProjekat.model.users;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.CancelledAppointment;

@Entity
@Table(name = "donors")

public class Donor extends User {

    @Column(name = "loyaltyPoints")
    private int loyaltyPoints;

    @Column(name = "penaltyPoints")
    private int penaltyPoints;

    @Enumerated(EnumType.STRING)
    private DonorCategory donorCategory;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Clinic> clinics;

    @OneToMany(mappedBy = "donor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    @JsonManagedReference
	@OneToMany(mappedBy = "donor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CancelledAppointment> cancelledAppointments;

    @Column
    private Date lastDonacion;
    
    @Column
    private boolean form;


    public Set<CancelledAppointment> getCancelledAppointments() {
        return this.cancelledAppointments;
    }

    public void setCancelledAppointments(Set<CancelledAppointment> cancelledAppointments) {
        this.cancelledAppointments = cancelledAppointments;
    }



    public Set<Clinic> getClinics() {
        return this.clinics;
    }

    public void setClinics(Set<Clinic> clinics) {
        this.clinics = clinics;
    }

    public Set<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Date getLastDonacion() {
        return this.lastDonacion;
    }

    public void setLastDonacion(Date lastDonacion) {
        this.lastDonacion = lastDonacion;
    }

    public boolean isForm() {
        return this.form;
    }

    public boolean getForm() {
        return this.form;
    }

    public void setForm(boolean form) {
        this.form = form;
    }


    public Donor() {
    }

    public int getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public int getPenaltyPoints() {
        return this.penaltyPoints;
    }

    public void setPenaltyPoints(int penaltyPoints) {
        this.penaltyPoints = penaltyPoints;
    }

    public DonorCategory getDonorCategory() {
        return this.donorCategory;
    }

    public void setDonorCategory(DonorCategory donorCategory) {
        this.donorCategory = donorCategory;
    }

}
