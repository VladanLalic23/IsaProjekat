package ftn.IsaProjekat.dto;


import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.users.Staff;



public class StaffDTO {
	
	private long id;
	private String name;
	private String surname;
	private String email;
	private long clinicId;
	private String clinicName;
	
	
	public StaffDTO() {
		super();
	}

	public StaffDTO(long id, String name, String surname, String email, double averageGrade) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public StaffDTO(Staff staff, Clinic clinic) {
		this.id = staff.getId();
		this.name = staff.getName();
		this.surname = staff.getSurname();
		this.email = staff.getEmail();
		this.clinicId = clinic.getId();
		this.clinicName = clinic.getName();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getClinicId() {
		return this.clinicId;
	}

	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicName() {
		return this.clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}



}
