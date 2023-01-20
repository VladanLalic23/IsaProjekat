package ftn.IsaProjekat.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.CreateAppointmentDTO;
import ftn.IsaProjekat.dto.DonorAppointmentDTO;
import ftn.IsaProjekat.dto.ScheduleAppointmentDTO;
import ftn.IsaProjekat.mappers.AppointmentMapper;
import ftn.IsaProjekat.mappers.EmailMapper;
import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.AppointmentStatus;
import ftn.IsaProjekat.model.clinic.CancelledAppointment;
import ftn.IsaProjekat.model.clinic.Clinic;
import ftn.IsaProjekat.model.clinic.TimeInterval;
import ftn.IsaProjekat.model.users.Donor;
import ftn.IsaProjekat.model.users.Staff;
import ftn.IsaProjekat.repository.AppointmentRepository;
import ftn.IsaProjekat.repository.DonorRepository;

import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private StaffService staffService;

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private EmailService emailService;



	public Appointment findById(Long id) {
		return appointmentRepository.findById(id).orElse(null);
    }

    public boolean createAppointment(CreateAppointmentDTO appointmentDTO) throws ParseException {    
    Staff staff=staffService.findById(appointmentDTO.getStaffId());
    Clinic clinic=clinicService.findById(staff.getClinic().getId());

    TimeInterval timeInterval = new TimeInterval(appointmentDTO.getStartDate(),appointmentDTO.getEndDate());
    Appointment appointment = new Appointment();

    appointment.setDonor(null);
    appointment.setStaffId(appointmentDTO.getStaffId());
    appointment.setStatus(AppointmentStatus.AVAILABLE);
    appointment.setClinic(clinic);
    appointment.setTimeInterval(timeInterval);
    appointmentRepository.save(appointment);
    return true;
}


}
