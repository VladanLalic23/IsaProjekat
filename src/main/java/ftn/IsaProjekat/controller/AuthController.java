package ftn.IsaProjekat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import ftn.IsaProjekat.dto.UserRegistrationDTO;
import ftn.IsaProjekat.dto.UserTokenState;
import ftn.IsaProjekat.model.users.User;
import ftn.IsaProjekat.security.ResourceConflictException;
import ftn.IsaProjekat.security.TokenUtils;
import ftn.IsaProjekat.security.auth.JwtAuthenticationRequest;
import ftn.IsaProjekat.service.DonorService;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins ="http://localhost:8080")
public class AuthController {
 
    @Autowired
    private DonorService donorService;

    @Autowired
	  private AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;

  
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

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
        HttpServletResponse response) {
      try {
        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                authenticationRequest.getPassword()));
  
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();
        return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
      }catch(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }catch(DisabledException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }
    }
    


    
}
