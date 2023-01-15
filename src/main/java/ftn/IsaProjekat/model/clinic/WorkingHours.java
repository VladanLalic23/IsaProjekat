package ftn.IsaProjekat.model.clinic;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import ftn.IsaProjekat.model.users.ClinicAdmin;

@Entity
@Table(name = "workingHours")
public class WorkingHours {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Clinic clinic;   
    
	@JsonManagedReference
	@ManyToMany(mappedBy = "workingHours", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicAdmin> staff;

    @Embedded
	private TimeInterval timeInterval;


    public WorkingHours() {
    }

    public WorkingHours(long id, Clinic clinic, Set<ClinicAdmin> staff, TimeInterval timeInterval) {
        super();
        this.id = id;
        this.clinic = clinic;
        this.staff = staff;
        this.timeInterval = timeInterval;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Clinic getClinic() {
        return this.clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Set<ClinicAdmin> getStaff() {
        return this.staff;
    }

    public void setStaff(Set<ClinicAdmin> staff) {
        this.staff = staff;
    }

    public TimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }


	

}