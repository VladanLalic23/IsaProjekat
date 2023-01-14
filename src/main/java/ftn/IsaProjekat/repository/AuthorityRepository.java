package ftn.IsaProjekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.IsaProjekat.model.users.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    
	Authority findByName(String name);
    
}