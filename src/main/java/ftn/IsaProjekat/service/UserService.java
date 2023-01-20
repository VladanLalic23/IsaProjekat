package ftn.IsaProjekat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	


    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = (userRepository.findByEmail(email));

		if(user == null)
			throw new UsernameNotFoundException("User with "+ email+" doesn't exists!");
		return user;
	}

	public boolean currentUserIsValid(Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(((User)authentication.getPrincipal()).getId() != id) {
			return false;
		}
		return true;
	}
    
}
 