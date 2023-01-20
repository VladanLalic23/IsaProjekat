package ftn.IsaProjekat.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.clinic.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {


    
}
