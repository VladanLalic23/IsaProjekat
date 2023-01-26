package ftn.IsaProjekat.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.IsaProjekat.dto.ComplaintAnswerDTO;
import ftn.IsaProjekat.dto.ComplaintDTO;
import ftn.IsaProjekat.mappers.ComplaintMapper;
import ftn.IsaProjekat.mappers.EmailMapper;
import ftn.IsaProjekat.model.clinic.Complaint;
import ftn.IsaProjekat.repository.ComplaintRepository;
import ftn.IsaProjekat.service.ComplaintService;
import ftn.IsaProjekat.service.EmailService;
import ftn.IsaProjekat.service.UserService;

@RestController
@RequestMapping(value = "/complaint")
@CrossOrigin(origins ="http://localhost:8080")
public class ComplaintController {

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private ComplaintService complaintService;

    @Autowired
    private ComplaintRepository complaintRepository;

	@Autowired
	private EmailService emailService;

    @PreAuthorize("hasRole('ROLE_DONOR')")
	@PostMapping("/create")
    public ResponseEntity<Complaint> createComplaint(@RequestBody ComplaintDTO complaintDTO) {
		if(!userDetailsService.currentUserIsValid(complaintDTO.getDonorId())) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		Complaint complaint = complaintService.createComplaint(complaintDTO);
        return new ResponseEntity<>(complaint, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/all")
	public ResponseEntity<Set<ComplaintDTO>> findAllUnanswered(){
		Set<Complaint> allComplaints = complaintService.findAllUnanswered();
		return new ResponseEntity<>(ComplaintMapper.createComplaintDTOSetfromComplaintList(allComplaints), HttpStatus.OK);
	}

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/answer")
    public ResponseEntity<ComplaintDTO> ComplaintAnswer(@RequestBody ComplaintAnswerDTO answerDTO) {
		Complaint complaint = complaintService.findById(answerDTO.getComplaintId());
		if (complaint == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ComplaintMapper.AnswerDTOToComplaint(answerDTO, complaint);
		complaint = complaintRepository.save(complaint);
		if (complaint != null)
		emailService.sendAnswerNotification(EmailMapper.createEmailDTOfromComplaint(complaint));

        return new ResponseEntity<>(ComplaintMapper.ComplaintToComplaintDTO(complaint), HttpStatus.OK);
	}
    
}
