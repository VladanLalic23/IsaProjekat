package ftn.IsaProjekat.service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.AvailableAppointmentDTO;
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

    @Autowired
    private TimeIntervalService timeIntervalService;

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public boolean createAppointment(CreateAppointmentDTO appointmentDTO) throws ParseException {
        Staff staff = staffService.findById(appointmentDTO.getStaffId());
        Clinic clinic = clinicService.findById(staff.getClinic().getId());

        TimeInterval timeInterval = new TimeInterval(appointmentDTO.getStartDate(), appointmentDTO.getEndDate());
        Appointment appointment = new Appointment();

        appointment.setDonor(null);
        appointment.setStaffId(appointmentDTO.getStaffId());
        appointment.setStatus(AppointmentStatus.AVAILABLE);
        appointment.setClinic(clinic);
        appointment.setTimeInterval(timeInterval);
        appointmentRepository.save(appointment);
        return true;
    }

    public Set<DonorAppointmentDTO> findAvailableAppointmentsByClinicId(long id) {
        Set<Appointment> appointments = appointmentRepository.findAvailableAppointmentsByClinicId(id);
        Set<DonorAppointmentDTO> appointmentDTOs = AppointmentMapper.freeAppointmet(appointments);
        return appointmentDTOs;
    }

    @Transactional(readOnly = false)
    public Appointment scheduleAppointment(ScheduleAppointmentDTO scheduleAppointmentDTO) {
        Appointment appointment = appointmentRepository.findById(scheduleAppointmentDTO.getAppointmentId())
                .orElse(null);
        Donor donor = donorRepository.findById(scheduleAppointmentDTO.getDonorId()).orElse(null);
        LocalDate lastDonation = donor.getLastDonacion().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (appointment.getStatus().equals(AppointmentStatus.SCHEDULED) || (donor.getForm() == false)
                || (lastDonation.minusMonths(6).isBefore(LocalDate.now()))) {
            return null;
        }
        appointment.setDonor(donor);
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        if (savedAppointment != null)
            emailService.sendAppointmentScheduledNotification(EmailMapper.createEmailDTOfromAppointment(appointment));
        return savedAppointment;
    }

    public Boolean cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElse(null);
        LocalDate appointmentStartDate = appointment.getTimeInterval().getStartTime().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        if (!appointmentStartDate.minusDays(1).isBefore(LocalDate.now())) {
            addCancelledAppointmentToDonor(appointment);
            appointment.setDonor(null);
            appointment.setStatus(AppointmentStatus.AVAILABLE);
            appointmentRepository.save(appointment);
            return true;
        }
        return false;
    }

    private void addCancelledAppointmentToDonor(Appointment appointment) {
        Donor donor = donorRepository.findById(appointment.getDonor().getId()).orElse(null);
        CancelledAppointment cancelledAppointment = new CancelledAppointment(appointment);
        cancelledAppointment.setStatus(AppointmentStatus.CANCELED);
        donor.getCancelledAppointments().add(cancelledAppointment);
        donorRepository.save(donor);
    }

    public Set<AvailableAppointmentDTO> getAvailableAppointmentsFromTimeInterval(TimeInterval timeInterval) {
        Set<Appointment> availableAppointments = appointmentRepository.findAvailableAppointments();
        Set<AvailableAppointmentDTO> availableAppointmentsInTime = new HashSet<AvailableAppointmentDTO>();
        Date startIntervall = timeIntervalService.formatDate(timeInterval.getStartTime());
        Date endIntervall = timeIntervalService.formatDate(timeInterval.getEndTime());

        for (Appointment proba : availableAppointments) {
            Date startAppointment = timeIntervalService.formatDate(proba.getTimeInterval().getStartTime());
            Date endAppointment = timeIntervalService.formatDate(proba.getTimeInterval().getEndTime());
            if(startAppointment.after(startIntervall) && endAppointment.before(endIntervall)){
                AvailableAppointmentDTO av = new AvailableAppointmentDTO(proba);
                availableAppointmentsInTime.add(av);
            }

        }
        return availableAppointmentsInTime;

    }

    

	public Set<Appointment> findPastAppointmentsByDonorId(Long id) {
		return appointmentRepository.findPastAppointmentsByDonorId(id);
	}
    
	public Set<Appointment> findScheduledAppointmentsByDonorId(Long id) {
		return appointmentRepository.findScheduledAppointmentsByDonorId(id);
	}

}   
