package ftn.IsaProjekat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import ftn.IsaProjekat.model.users.User;
 
public interface UserRepository extends JpaRepository<User,Long>{
    User findByEmail(String email);	

    
}
