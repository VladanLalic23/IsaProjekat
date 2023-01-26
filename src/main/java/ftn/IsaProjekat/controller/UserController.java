package ftn.IsaProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.UserDTO;
import ftn.IsaProjekat.mappers.UserMapper;
import ftn.IsaProjekat.model.users.User;
import ftn.IsaProjekat.repository.UserRepository;
import ftn.IsaProjekat.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updatePersonalInformations(@RequestBody UserDTO userDTO) {
		User user = userService.findById(userDTO.getId());
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		UserMapper.UserDTOToExistingUser(userDTO, user);
		user = userRepository.save(user);
		return new ResponseEntity<>(UserMapper.UserToUserDTO(user), HttpStatus.OK);
	}

	@GetMapping(value = "/find-by-id/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else if(!userService.currentUserIsValid(id)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>(UserMapper.UserToUserDTO(user), HttpStatus.OK);
	}
    
}
    

