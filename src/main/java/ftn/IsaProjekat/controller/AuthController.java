package ftn.IsaProjekat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import ftn.IsaProjekat.dto.UserRegistrationDTO;
import ftn.IsaProjekat.security.ResourceConflictException;
import ftn.IsaProjekat.service.DonorService;


@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
 
    @Autowired
    private DonorService donorService;

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
		try {
			String donorEmail = donorService.registerDonor(userRegistrationDTO);
			return new ResponseEntity<>(donorEmail, HttpStatus.CREATED);
		}
        catch(ResourceConflictException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
    }

    @GetMapping("activate/{id}")
    public void activateAccount(@PathVariable Long id, HttpServletResponse httpServletResponse) {
      donorService.activateDonorAccount(id);
    }
    


    
}
