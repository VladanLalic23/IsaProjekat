package ftn.IsaProjekat.service;

import java.util.List;

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
		return clinicRepository.findById(id).orElse(null);
	}

	@Override
	public Clinic findByName(String name) {	
		return clinicRepository.findByName(name);
	}

	@Override
	public List<Clinic> findAll() {
		List<Clinic> clinics = clinicRepository.findAll();

		return clinics;
	}
    
	
    
}
