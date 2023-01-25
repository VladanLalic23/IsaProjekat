package ftn.IsaProjekat.service.interfaces;

import java.util.List;

import ftn.IsaProjekat.model.clinic.Clinic;

public interface IClinicService {
	Clinic findById(Long id);
	Clinic findByName(String name);
	List<Clinic> findAll();
}