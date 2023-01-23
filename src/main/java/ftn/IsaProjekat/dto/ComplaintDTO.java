package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.clinic.ComplaintType;

public class ComplaintDTO {
    private Long complaintId;
    private Long donorId;
	private Long complaineeId;
	private String complaintText;

    private ComplaintType complaintType;



    public ComplaintDTO() {
    }


    
    public ComplaintDTO(Long complaintId, Long donorId, Long complaineeId, String complaintText, ComplaintType complaintType) {
        this.complaintId = complaintId;
        this.donorId = donorId;
        this.complaineeId = complaineeId;
        this.complaintText = complaintText;
        this.complaintType = complaintType;
    }






    public ComplaintType getComplaintType() {
        return this.complaintType;
    }

    public void setComplaintType(ComplaintType complaintType) {
        this.complaintType = complaintType;
    }




    public Long getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getDonorId() {
        return this.donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public Long getComplaineeId() {
        return this.complaineeId;
    }

    public void setComplaineeId(Long complaineeId) {
        this.complaineeId = complaineeId;
    }

    public String getComplaintText() {
        return this.complaintText;
    }

    public void setComplaintText(String complaintText) {
        this.complaintText = complaintText;
    }



    
}
