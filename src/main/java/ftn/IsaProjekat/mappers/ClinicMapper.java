package ftn.IsaProjekat.mappers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ftn.IsaProjekat.dto.ClinicDTO;
import ftn.IsaProjekat.model.clinic.Clinic;

public class ClinicMapper {



    public static Set<ClinicDTO> createClinicDTOSetfromClinicList(List<Clinic> clinics) {
		Set<ClinicDTO> clinicDTOs = new HashSet<ClinicDTO>();
		for(Clinic clinic : clinics) {
			clinicDTOs.add(new ClinicDTO(clinic));
		}
		return clinicDTOs;
	}


}
