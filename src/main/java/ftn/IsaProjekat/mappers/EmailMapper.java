package ftn.IsaProjekat.mappers;

import ftn.IsaProjekat.dto.AppointmentSchedulingEmailDTO;
import ftn.IsaProjekat.dto.ComplaintEmailDTO;
import  ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.Complaint;
import ftn.IsaProjekat.model.users.Address;



public class EmailMapper {

	public static AppointmentSchedulingEmailDTO createEmailDTOfromAppointment(Appointment appointment) {
		return new AppointmentSchedulingEmailDTO(appointment.getDonor().getEmail(), appointment.getClinic().getName(),
				createAddressString(appointment.getClinic().getAddress()), appointment.getTimeInterval().getStartTime());
	}
	
	private static String createAddressString(Address address) {
		return address.getStreetName() + " " +address.getStreetNumber() + " " + address.getCity();
	}

	public static ComplaintEmailDTO createEmailDTOfromComplaint(Complaint complaint) {
		return new ComplaintEmailDTO(complaint.getDonor().getEmail(),complaint.getAnswerText());
	}
	
}