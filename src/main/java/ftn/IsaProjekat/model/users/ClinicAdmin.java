package ftn.IsaProjekat.model.users;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.IsaProjekat.model.clinic.Clinic;

@Entity
@Table(name="clinic_admin")

public class ClinicAdmin extends User {

@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
private Clinic clinic;


}

