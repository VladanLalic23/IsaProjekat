package ftn.IsaProjekat.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.users.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long> {

    @Query(value = "SELECT staffs FROM Clinic s WHERE s.id = ?1")
	Set<Staff> findAllByClinic(Long id);
    
}
