package ftn.IsaProjekat.repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.clinic.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    @Query(value = "SELECT a FROM Appointment a WHERE a.clinic.id = ?1 and a.status = 'AVAILABLE' ")
    Set<Appointment> findAvailableAppointmentsByClinicId(Long id);

    
}
