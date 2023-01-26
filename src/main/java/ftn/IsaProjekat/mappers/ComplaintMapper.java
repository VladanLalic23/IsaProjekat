package ftn.IsaProjekat.mappers;

import java.util.HashSet;

import java.util.Set;

import ftn.IsaProjekat.dto.ComplaintAnswerDTO;
import ftn.IsaProjekat.dto.ComplaintDTO;
import ftn.IsaProjekat.model.clinic.Complaint;

public class ComplaintMapper {

    public static void createComplaintFromComplaintDTO(Complaint complaint, ComplaintDTO complaintDTO) {
		complaint.setComplaintText(complaintDTO.getComplaintText());
		complaint.setComplaineeId(complaintDTO.getComplaineeId());
        complaint.setType(complaintDTO.getComplaintType());
        complaint.setAnswered(false);
		complaint.setAnswerText(null);
	}

  public static Set<ComplaintDTO> createComplaintDTOSetfromComplaintList(Set<Complaint> complaints) {
		Set<ComplaintDTO> complaintDTOs = new HashSet<ComplaintDTO>();
		for(Complaint complaint : complaints) {
			complaintDTOs.add(new ComplaintDTO(complaint));
		}
		return complaintDTOs;
	}


	public static void AnswerDTOToComplaint(ComplaintAnswerDTO answerDTO, Complaint complaint) {
		complaint.setAnswered(true);
		complaint.setAnswerText(answerDTO.getAnswerText());
	}

	public static ComplaintDTO ComplaintToComplaintDTO(Complaint complaint) {
		return new ComplaintDTO(complaint);
	}
    


}
