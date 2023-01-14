package ftn.IsaProjekat.model.clinic;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ftn.IsaProjekat.model.users.Donor;

@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Table(name="appointment")

public class Appointment {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "time", nullable = false)
    private Time time;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "isFree", nullable = false)
	private Boolean isFree;
	 
	@JsonManagedReference
    @ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Donor> Donor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Set<Donor> getDonor() {
        return Donor;
    }

    public void setDonor(Set<Donor> donor) {
        Donor = donor;
    }
}