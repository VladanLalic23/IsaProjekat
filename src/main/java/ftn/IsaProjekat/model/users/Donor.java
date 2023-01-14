package ftn.IsaProjekat.model.users;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ftn.IsaProjekat.model.clinic.Clinic;

@Entity
@Table(name="donors")

public class Donor extends User {

    @Column(name = "loyaltyPoints")
	private int loyaltyPoints;
	
	@Column(name = "penaltyPoints")
	private int penaltyPoints;
    
	@Enumerated(EnumType.STRING)
	private DonorCategory donorCategory;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Clinic> clinics;


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
