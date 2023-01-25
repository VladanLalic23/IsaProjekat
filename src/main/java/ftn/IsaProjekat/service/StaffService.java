package ftn.IsaProjekat.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.StaffDTO;
import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.users.Staff;
import ftn.IsaProjekat.repository.ClinicRepository;
import ftn.IsaProjekat.repository.StaffRepository;
import ftn.IsaProjekat.service.interfaces.IStaffService;
import ftn.IsaProjekat.mappers.StaffMapper;



@Service
public class StaffService implements IStaffService {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
	public Staff findById(long id) {
		return staffRepository.findById(id).orElse(null);
	}

    @Override
    public Set<StaffDTO> findAllByClinic(Long id) {
		Set<Staff> staff = staffRepository.findAllByClinic(id);
		Clinic clinic = clinicRepository.findById(id).orElse(null);
		Set<StaffDTO> staffDTO = new HashSet<StaffDTO>();
		if(clinic != null && !staff.isEmpty()) {
			staffDTO = StaffMapper.staffToStaffDTO(staff, clinic);
		}
		return staffDTO;
	}





    
}
