package ftn.IsaProjekat.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.clinic.Appointment;
import ftn.IsaProjekat.model.clinic.TimeInterval;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT a FROM Appointment a WHERE a.status = 'AVAILABLE' ")
    Set<Appointment> findAvailableAppointments();
    @Query(value = "SELECT a FROM Appointment a WHERE a.clinic.id = ?1and  a.status = 'AVAILABLE' ")
    Set<Appointment> findAvailableAppointmentsByClinicId(Long id);

    
}
