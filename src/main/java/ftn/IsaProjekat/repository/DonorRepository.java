package ftn.IsaProjekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ftn.IsaProjekat.model.users.Donor;

public interface DonorRepository extends JpaRepository<Donor,Long>{
   

    Donor findByEmail(String email);	

    
}
