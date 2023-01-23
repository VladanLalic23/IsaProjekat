package ftn.IsaProjekat.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.clinic.Clinic;

public interface ClinicRepository extends JpaRepository <Clinic,Long> {

    @Query(value = "SELECT c FROM Clinic c")
	Set<Clinic> findAllClinics();

    Clinic findByName(String name);
    
}
