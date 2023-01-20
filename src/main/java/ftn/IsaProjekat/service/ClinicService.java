package ftn.IsaProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.repository.ClinicRepository;
import ftn.IsaProjekat.service.interfaces.IClinicService;

@Service
public class ClinicService implements IClinicService{


    @Autowired
    private ClinicRepository clinicRepository;

    @Override
	public Clinic findById(Long id) {
		Clinic clinic = clinicRepository.findById(id).orElse(null);		
		return clinic;
	}

    
}
