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
import ftn.IsaProjekat.dto.CreateAppointmentDTO;
import ftn.IsaProjekat.dto.DonorAppointmentDTO;
import ftn.IsaProjekat.dto.ScheduleAppointmentDTO;
import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.Clinic;
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

	}

	










    
}
