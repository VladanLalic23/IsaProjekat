package ftn.IsaProjekat.model.users;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import ftn.IsaProjekat.model.clinic.Clinic;

@Entity
public class ClinicAdmin extends User {

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Clinic clinic;

    
}

