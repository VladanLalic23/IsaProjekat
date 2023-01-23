package ftn.IsaProjekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.ComplaintDTO;
import ftn.IsaProjekat.model.clinic.Complaint;
import ftn.IsaProjekat.service.ComplaintService;
import ftn.IsaProjekat.service.UserService;

@RestController
@RequestMapping(value = "/complaint")
@CrossOrigin(origins ="http://localhost:8080")
public class ComplaintController {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private ComplaintService complaintService;

    @PreAuthorize("hasRole('ROLE_DONOR')")
	@PostMapping("/create")
    public ResponseEntity<Complaint> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
		if(!userDetailsService.currentUserIsValid(complaintDTO.getDonorId())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		Complaint complaint = complaintService.createComplaint(complaintDTO);
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }
    
}
