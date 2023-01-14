package ftn.IsaProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import ftn.IsaProjekat.model.users.User;
import ftn.IsaProjekat.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = (userRepository.findByEmail(email));

		if(user == null)
			throw new UsernameNotFoundException("User with "+ email+" doesn't exists!");



		return user;
	}
    
}
 