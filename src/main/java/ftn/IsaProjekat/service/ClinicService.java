package ftn.IsaProjekat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.ClinicProfileDTO;
import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.users.Staff;
import ftn.IsaProjekat.repository.ClinicRepository;
import ftn.IsaProjekat.service.interfaces.IClinicService;
import ftn.IsaProjekat.service.interfaces.IStaffService;

@Service
public class ClinicService implements IClinicService{


    @Autowired
    private ClinicRepository clinicRepository;

	@Autowired
    private IStaffService staffService;

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
	@Override
	public Clinic findClinicByStaff(Long id){
		Staff staff = staffService.findById(id);	
		return staff.getClinic();   
	}
    
	@Override
	public ClinicProfileDTO findClinicProfileInformation(Long id) {
		Clinic clinic = findClinicByStaff(id);
		if(clinic != null) {
			return new ClinicProfileDTO(clinic);
		}
		return null;
	}
	
    
}
