package ftn.IsaProjekat.service.interfaces;

import ftn.IsaProjekat.model.clinic.Clinic;

public interface IClinicService {
	Clinic findById(Long id);
}