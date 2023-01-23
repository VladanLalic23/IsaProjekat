package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.users.Donor;
import ftn.IsaProjekat.model.users.DonorCategory;

public class DonorProfileDTO {

    private long id;
	private String name;
	private String surname;
	private String email;
    private int loyaltyPoints;
    private int penaltyPoints;
    private DonorCategory donorCategory;


    public DonorProfileDTO() {
    }

    public DonorProfileDTO(long id, String name, String surname, String email, int loyaltyPoints, int penaltyPoints, DonorCategory donorCategory) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
        this.penaltyPoints = penaltyPoints;
        this.donorCategory = donorCategory;
    }
    public DonorProfileDTO(Donor donor) {
        this.id = donor.getId();
        this.name = donor.getName();
        this.surname = donor.getSurname();
        this.email = donor.getEmail();
        this.loyaltyPoints = donor.getLoyaltyPoints() ;
        this.penaltyPoints = donor.getPenaltyPoints();
        this.donorCategory = donor.getDonorCategory();
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
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
