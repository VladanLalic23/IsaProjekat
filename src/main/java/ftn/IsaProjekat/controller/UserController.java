package ftn.IsaProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    
}
