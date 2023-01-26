package ftn.IsaProjekat.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.dto.AppointmentDTO;
import ftn.IsaProjekat.model.clinic.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT a FROM Appointment a WHERE a.status = 'AVAILABLE' ")
    Set<Appointment> findAvailableAppointments();
    @Query(value = "SELECT a FROM Appointment a WHERE a.clinic.id = ?1 and  a.status = 'AVAILABLE'")
    Set<Appointment> findAvailableAppointmentsByClinicId(Long id);
    @Query(value = "SELECT a FROM Appointment a WHERE a.donor.id = ?1 and a.status = 'SUCCEEDED' ")
    Set<AppointmentDTO> findPastAppointmentsByDonorId(Long id);
    @Query(value = "SELECT a FROM Appointment a WHERE a.donor.id = ?1"
    + " AND a.status = 'SCHEDULED'")
    Set<AppointmentDTO> findScheduledAppointmentsByDonorId(Long id);

    @Query(value = "SELECT a FROM Appointment a WHERE a.status = 'AVAILABLE' AND a.timeInterval.startTime >= ?1")
    Set<Appointment> findAvailableClinicByDate(Date appointmentTime);

    @Query(value = "SELECT a FROM Appointment a WHERE a.status = 'AVAILABLE' AND a.timeInterval.startTime >= ?1 AND a.clinic.id = ?2")
	Set<Appointment> findAvailableClinicIdAndDate(Date appointmentTime, Long clinicId);

    
}
