package ftn.IsaProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.IsaProjekat.model.clinic.Complaint;

public interface ComplaintRepository extends JpaRepository <Complaint,Long> {
    
}
