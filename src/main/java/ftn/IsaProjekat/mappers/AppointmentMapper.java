package ftn.IsaProjekat.mappers;

import java.util.HashSet;
import java.util.Set;

import ftn.IsaProjekat.dto.DonorAppointmentDTO;
import ftn.IsaProjekat.model.clinic.Appointment;

public class AppointmentMapper {


	public static Set<DonorAppointmentDTO> freeAppointmet(Set<Appointment> appointments) {
		Set<DonorAppointmentDTO> appointmentDTOs = new HashSet<DonorAppointmentDTO>();
		for(Appointment appointment : appointments) {
			appointmentDTOs.add(new DonorAppointmentDTO(appointment));
		}
		return appointmentDTOs;
	}
    
}
