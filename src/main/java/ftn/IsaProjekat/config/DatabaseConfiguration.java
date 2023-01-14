package ftn.IsaProjekat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ftn.IsaProjekat.model.users.Address;
import ftn.IsaProjekat.model.users.Gender;
import ftn.IsaProjekat.model.users.Role;
import ftn.IsaProjekat.model.users.User;
import ftn.IsaProjekat.repository.UserRepository;



@Configuration
public class DatabaseConfiguration {



@Autowired
private UserRepository userRepository;


    @Bean
    public boolean instantiate(){

        Address adresa1= new Address();
        adresa1.setCountry("bih");
        adresa1.setCity("bn");
        adresa1.setFlatNumber(4);
        adresa1.setPostalCode("76000");
        adresa1.setStreetName("Loznicka");
        adresa1.setStreetNumber(36);

        User user1=new User();
        user1.setEmail("admin@gmail.com");
        user1.setRole(Role.ROLE_ADMIN);
        user1.setName("Vladan");
        user1.setSurname("Lalic");
        user1.setInfo("nista nema");
        user1.setProfession("studentjosmalo");
        user1.setPassword("123");
        user1.setInitialPasswordChanged(true);
        user1.setIsActivated(true);
        user1.setPhone("123123123");
        user1.setGender(Gender.MALE);
        user1.setJmbg("1231231231231");
        user1.setLastPasswordResetDate(null);
        user1.setAddress(adresa1);
        userRepository.save(user1);



    
    
    return true;
    }


}

