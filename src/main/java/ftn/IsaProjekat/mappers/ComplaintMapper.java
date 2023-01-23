package ftn.IsaProjekat.mappers;

import ftn.IsaProjekat.dto.ComplaintDTO;
import ftn.IsaProjekat.model.clinic.Complaint;

public class ComplaintMapper {

    public static void createComplaintFromComplaintDTO(Complaint complaint, ComplaintDTO complaintDTO) {
		complaint.setComplaintText(complaintDTO.getComplaintText());
		complaint.setComplaineeId(complaintDTO.getComplaineeId());
        complaint.setType(complaintDTO.getComplaintType());
        complaint.setAnswered(false);
	}
    
}
