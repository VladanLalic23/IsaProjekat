package ftn.IsaProjekat.mappers;

import java.util.HashSet;
import java.util.Set;

import ftn.IsaProjekat.dto.StaffDTO;
import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.users.Staff;

public class StaffMapper {

    public static Set<StaffDTO> staffToStaffDTO(Set<Staff> staffs, Clinic clinic) {
		Set<StaffDTO> staffDTO = new HashSet<StaffDTO>();
		for(Staff staff : staffs) {
			staffDTO.add(new StaffDTO(staff, clinic));
		}
		return staffDTO;
	}


	
    
}
