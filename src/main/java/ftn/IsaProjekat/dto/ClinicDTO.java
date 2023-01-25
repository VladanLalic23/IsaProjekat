package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.clinic.Clinic;

public class ClinicDTO {
	private Long id;
	private String name;
	private double averageGrade;
	private String city;
	private String country;
	private String streetName;
	private int streetNumber;
	private int flatNumber;
	
	public ClinicDTO() {
		
	}
	
	public ClinicDTO(Long id, String name, double averageGrade, String city, String country, String streetName,
			int streetNumber, int flatNumber) {
		super();
		this.id = id;
		this.name = name;
		this.averageGrade = averageGrade;
		this.city = city;
		this.country = country;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.flatNumber = flatNumber;
	}
	
	public ClinicDTO(Clinic clinic) {
		this.id = clinic.getId();
		this.name = clinic.getName();
		this.averageGrade = clinic.getAverageGrade();
		this.city = clinic.getAddress().getCity();
		this.country = clinic.getAddress().getCountry();
		this.streetName = clinic.getAddress().getStreetName();
		this.streetNumber = clinic.getAddress().getStreetNumber();
		this.flatNumber = clinic.getAddress().getFlatNumber();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverageGrade() {
		return averageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
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
}