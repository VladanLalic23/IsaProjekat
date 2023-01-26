package ftn.IsaProjekat.service;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.IsaProjekat.dto.ComplaintDTO;
import ftn.IsaProjekat.mappers.ComplaintMapper;
import ftn.IsaProjekat.model.clinic.Complaint;
import ftn.IsaProjekat.model.users.Donor;
import ftn.IsaProjekat.repository.ComplaintRepository;
import ftn.IsaProjekat.repository.DonorRepository;

@Service
public class ComplaintService {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private ComplaintRepository complaintRepository;




	public Complaint createComplaint(ComplaintDTO complaintDTO) {
		Donor donor = donorRepository.findById(complaintDTO.getDonorId()).orElse(null);

		Complaint complaint = new Complaint();
		ComplaintMapper.createComplaintFromComplaintDTO(complaint, complaintDTO);
		complaint.setDonor(donor);
	
		return complaintRepository.save(complaint);
	}

	public Set<Complaint> findAllUnanswered() {
		Set<Complaint> complaints = complaintRepository.findAllUnanswered();

		return complaints;
	}

	public Complaint findById(Long id) {
		return complaintRepository.findById(id).orElse(null);
	}

	public Set<ComplaintDTO> findComplaintsByDonorId(Long id) {
		return complaintRepository.findComplaintsByDonorId(id);
	}

	public Set<ComplaintDTO> findAnswredComplaints() {
		return complaintRepository.findAnswredComplaints();
	}

    
}
