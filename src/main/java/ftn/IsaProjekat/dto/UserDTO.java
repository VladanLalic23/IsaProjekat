package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.users.User;

public class UserDTO {

    private Long id;
	private String name;
	private String surname;
	private String country;
	private String city;
	private String postalCode;
	private int streetNumber;
	private int flatNumber;
	private String streetName;
	private String phoneNumber;


    public UserDTO() {
    }


    public UserDTO(Long id, String name, String surname, String country, String city, String postalCode, int streetNumber, int flatNumber, String streetName, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.streetName = streetName;
        this.phoneNumber = phoneNumber;
    }

    public UserDTO(User user) {
		this(user.getId(), user.getName(), 
				user.getSurname(), user.getAddress().getCountry(), user.getAddress().getCity(),
				user.getAddress().getPostalCode(), user.getAddress().getStreetNumber(),
				user.getAddress().getFlatNumber(), user.getAddress().getStreetName(), 
				user.getPhone());
	}


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getStreetNumber() {
        return this.streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getFlatNumber() {
        return this.flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
