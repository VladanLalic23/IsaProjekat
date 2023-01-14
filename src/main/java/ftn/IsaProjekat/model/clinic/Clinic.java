package ftn.IsaProjekat.model.clinic;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ftn.IsaProjekat.model.users.Address;
import ftn.IsaProjekat.model.users.ClinicAdmin;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name="clinic")

public class Clinic {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "averageGrade", nullable = true)
	private double averageGrade;

    @Embedded
	private Address address;


    @JsonManagedReference
    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicAdmin> clinicAdmins;


    public Clinic() {
    }

    public Clinic(long id, String name, String description, double averageGrade, Address address, Set<ClinicAdmin> clinicAdmins) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.averageGrade = averageGrade;
        this.address = address;
        this.clinicAdmins = clinicAdmins;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageGrade() {
        return this.averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
     public Set<ClinicAdmin> getClinicAdmins() {
        return this.clinicAdmins;
    }

    public void setClinicAdmins(Set<ClinicAdmin> workers) {
        this.clinicAdmins = workers;
    }




    
}
