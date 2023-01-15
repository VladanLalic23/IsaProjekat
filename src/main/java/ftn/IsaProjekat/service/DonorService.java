package ftn.IsaProjekat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.UserRegistrationDTO;
import ftn.IsaProjekat.mappers.DonorMapper;
import ftn.IsaProjekat.model.users.Authority;
import ftn.IsaProjekat.model.users.Donor;
import ftn.IsaProjekat.model.users.User;
import ftn.IsaProjekat.repository.AuthorityRepository;
import ftn.IsaProjekat.repository.DonorRepository;
import ftn.IsaProjekat.repository.UserRepository;
import ftn.IsaProjekat.security.ResourceConflictException;
import ftn.IsaProjekat.service.interfaces.DonorInterface;

import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class DonorService implements DonorInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private EmailService emailService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthorityRepository authorityRepository;


    @Override
	public String registerDonor(UserRegistrationDTO userRegistrationDTO) {
		User existUser = userRepository.findByEmail(userRegistrationDTO.getEmail());
		if(existUser !=null) {
			throw new ResourceConflictException(userRegistrationDTO.getEmail(), "Email already exists!"); 
		}
		userRegistrationDTO.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
		Donor donor = new Donor();
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(authorityRepository.findByName("ROLE_DONOR"));
		donor.setAuthorities(authorities);
		DonorMapper.createDonorFromRegistrationDTO(userRegistrationDTO, donor);
		Donor addedDonor = donorRepository.save(donor);
		emailService.sendConfirmationEmail(userRegistrationDTO, addedDonor.getId());
		return addedDonor.getEmail();
	}

	@Override
	public void activateDonorAccount(Long userId) {
		User activeUser = userRepository.getById(userId);
		activeUser.setIsActivated(true);
		userRepository.save(activeUser);	
	}

	public Donor findDonor(String email) {
		
		return 	donorRepository.findByEmail(email);
		
	}
    
}
