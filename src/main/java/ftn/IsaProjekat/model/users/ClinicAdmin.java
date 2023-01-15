package ftn.IsaProjekat.model.users;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.clinic.WorkingHours;

@Entity
@Table(name = "clinic_admin")

public class ClinicAdmin extends User {

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clinic clinic;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<WorkingHours> workingHours;

}
