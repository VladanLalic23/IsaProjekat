package ftn.IsaProjekat.service.interfaces;

import java.util.List;

import ftn.IsaProjekat.dto.ClinicProfileDTO;
import ftn.IsaProjekat.model.clinic.Clinic;

public interface IClinicService {
	Clinic findById(Long id);
	Clinic findByName(String name);
	List<Clinic> findAll();
	ClinicProfileDTO findClinicProfileInformation(Long id);
	Clinic findClinicByStaff(Long id);
}