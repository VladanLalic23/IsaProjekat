package ftn.IsaProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.IsaProjekat.model.users.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long> {
    
}
