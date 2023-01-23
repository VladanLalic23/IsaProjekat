package ftn.IsaProjekat.controller;
import java.text.ParseException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.AppointmentCancellationDTO;
import ftn.IsaProjekat.dto.AppointmentSearchDTO;
import ftn.IsaProjekat.dto.AvailableAppointmentDTO;
import ftn.IsaProjekat.dto.CreateAppointmentDTO;
import ftn.IsaProjekat.dto.DonorAppointmentDTO;
import ftn.IsaProjekat.dto.ScheduleAppointmentDTO;
import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.clinic.TimeInterval;
import ftn.IsaProjekat.service.AppointmentService;
import ftn.IsaProjekat.service.ClinicService;
import ftn.IsaProjekat.service.UserService;

@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

    @Autowired
	private AppointmentService appointmentService;

	@Autowired
	private ClinicService clinicService;

	@Autowired
	private UserService userDetailsService;



    @PreAuthorize("hasRole('ROLE_STAFF')")
	@PostMapping("/create")
	public ResponseEntity<CreateAppointmentDTO> createAppointment(@RequestBody CreateAppointmentDTO appointmentDTO)throws ParseException{
		if(appointmentService.createAppointment(appointmentDTO)) {
			return new ResponseEntity<>(appointmentDTO, HttpStatus.OK);
		}else {
			System.out.println("Ovde greska molim te!");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@PreAuthorize("hasRole('ROLE_DONOR')")
	@GetMapping( "/clinic/{id}")
	public ResponseEntity<Set<DonorAppointmentDTO>> findAvailableAppointmentsByClinicId(@PathVariable Long id) {
		Clinic clinic = clinicService.findById(id);
		if (clinic == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Set<DonorAppointmentDTO> appointments = appointmentService.findAvailableAppointmentsByClinicId(id);
		return new ResponseEntity<>(appointments , HttpStatus.OK);
	}	


	@PreAuthorize("hasAnyRole('ROLE_DONOR')")
	@PutMapping( "/schedule")
	public ResponseEntity<Appointment> scheduleAppointment(@RequestBody ScheduleAppointmentDTO scheduleAppointmentDTO) {
		Appointment scheduledAppointment = appointmentService.scheduleAppointment(scheduleAppointmentDTO);
		if(scheduledAppointment == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(scheduledAppointment , HttpStatus.OK);		}


	@PreAuthorize("hasRole('ROLE_DONOR')")
	@PutMapping( "/cancel")
	public ResponseEntity<Void> cancelAppointment(@RequestBody AppointmentCancellationDTO appointmentDTO) {
		if(appointmentService.findById(appointmentDTO.getAppointmentId()) == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if(!userDetailsService.currentUserIsValid(appointmentDTO.getDonorId())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		if(appointmentService.cancelAppointment(appointmentDTO.getAppointmentId())) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_DONOR')")
	@GetMapping( "/find-available-by-time")
	public ResponseEntity<Set<AvailableAppointmentDTO>> getAvailableAppointmentsFromTimeInterval(@RequestBody TimeInterval timeInterval){
		Set<AvailableAppointmentDTO> apps = appointmentService.getAvailableAppointmentsFromTimeInterval(timeInterval);
		if(apps == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(apps , HttpStatus.OK);

		}

	}











    

