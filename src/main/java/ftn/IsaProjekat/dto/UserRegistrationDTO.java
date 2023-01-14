package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.users.Gender;

public class UserRegistrationDTO {	
    
    private String email;
	private String password;
	private String name;
	private String surname;
	private Gender gender;
	private String streetName;
	private int streetNumber;
	private int flatNumber;
	private String city;
	private String postalCode;
	private String country;
	private String phone;
    private String profession;
    private String info;
    private String jmbg;


    public UserRegistrationDTO() {
    }


    public UserRegistrationDTO(String email, String password, String name, String surname, Gender gender, String streetName, int streetNumber, int flatNumber, String city, String postalCode, String country, String phone, String profession, String info, String jmbg) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.flatNumber = flatNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.profession = profession;
        this.info = info;
        this.jmbg = jmbg;
    }



    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getjmbg() {
        return this.jmbg;
    }

    public void setjmbg(String jmbg) {
        this.jmbg = jmbg;
    }

	
    
}
