package ftn.IsaProjekat.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.StaffDTO;
import ftn.IsaProjekat.model.users.Staff;
import ftn.IsaProjekat.service.StaffService;


@RestController
@RequestMapping(value = "/staff")
@CrossOrigin(origins ="http://localhost:8080")
public class StaffController {

    @Autowired
    private StaffService staffService;
    

    @PreAuthorize("hasRole('ROLE_STAFF')")
	@GetMapping("/all-by-clinic")
	public ResponseEntity<Set<StaffDTO>> findAllByClinic(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		long clinicId = ((Staff)authentication.getPrincipal()).getClinic().getId();
		Set<StaffDTO> staffDTO = staffService.findAllByClinic(clinicId);
		if(staffDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else if (!staffDTO.isEmpty()){
			return new ResponseEntity<>(staffDTO, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
