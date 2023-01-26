package ftn.IsaProjekat.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ftn.IsaProjekat.model.clinic.Complaint;

public interface ComplaintRepository extends JpaRepository <Complaint,Long> {

    @Query(value = "SELECT c FROM Complaint c WHERE c.answered = 'false' ")
    Set<Complaint> findAllUnanswered();
    
}
