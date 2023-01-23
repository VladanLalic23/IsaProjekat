package ftn.IsaProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.DonorProfileDTO;
import ftn.IsaProjekat.service.interfaces.DonorInterface;

@RestController
@RequestMapping(value = "/donor")
public class DonorController {

    @Autowired
    private DonorInterface donorService;
    
    @PreAuthorize("hasRole('ROLE_DONOR')")
	@GetMapping("/profile-info/{id}")
	public ResponseEntity<DonorProfileDTO> findDonorProfileInformation (@PathVariable Long id) {
		DonorProfileDTO donorProfileDTO = donorService.findDonorProfileInformation(id);
		if(donorProfileDTO == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(donorProfileDTO, HttpStatus.OK);	
    }
}
