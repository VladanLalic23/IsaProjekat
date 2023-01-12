package ftn.IsaProjekat.model.users;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
    private String country;
    private String city;
    private String postalCode;
    private int streetNumber;
    private int flatNumber;
    private String streetName;
    
    public Address() {
    	
    }
    
    public Address(String country, String city, String postalCode, int streetNumber, int flatNumber,
			String streetName) {
		super();
		this.country = country;
		this.city = city;
		this.postalCode = postalCode;
		this.streetNumber = streetNumber;
		this.flatNumber = flatNumber;
		this.streetName = streetName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
}