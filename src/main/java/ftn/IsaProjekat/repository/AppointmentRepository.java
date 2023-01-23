package ftn.IsaProjekat.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.clinic.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT a FROM Appointment a WHERE a.status = 'AVAILABLE' ")
    Set<Appointment> findAvailableAppointments();
    @Query(value = "SELECT a FROM Appointment a WHERE a.clinic.id = ?1and  a.status = 'AVAILABLE' ")
    Set<Appointment> findAvailableAppointmentsByClinicId(Long id);
    @Query(value = "SELECT a FROM Appointment a WHERE a.donor.id = ?1 and a.status = 'SUCCEEDED' ")
    Set<Appointment> findPastAppointmentsByDonorId(Long id);
    @Query(value = "SELECT a FROM Appointment a WHERE a.donor.id = ?1 and a.status = 'SCHEDULED'")
    Set<Appointment> findScheduledAppointmentsByDonorId(Long id);

    
}
