package ftn.IsaProjekat.model.clinic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import ftn.IsaProjekat.model.users.Donor;

@Entity
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
// property = "id")
@Table(name = "appointments")

public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private TimeInterval timeInterval;

    @Column
    @Enumerated(EnumType.STRING)
    private AppointmentStatus type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Donor donor;

    public Appointment() {
    }

    public Appointment(long id, TimeInterval timeInterval, AppointmentStatus type, Donor donor) {
        this.id = id;
        this.timeInterval = timeInterval;
        this.type = type;
        this.donor = donor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDonor(Donor donor) {
        donor = donor;
    }

    public TimeInterval getTimeInterval() {
        return this.timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public AppointmentStatus getType() {
        return this.type;
    }

    public void setType(AppointmentStatus type) {
        this.type = type;
    }

}