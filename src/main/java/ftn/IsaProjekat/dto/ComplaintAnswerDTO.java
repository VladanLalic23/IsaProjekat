package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.clinic.Complaint;


public class ComplaintAnswerDTO {
    private Long complaintId;
    private String answerText;


    public ComplaintAnswerDTO() {
    }


    public ComplaintAnswerDTO(Long complaintId, String answerText) {
        this.complaintId = complaintId;
        this.answerText = answerText;
    }

    public ComplaintAnswerDTO(Complaint complaint) {
        this.complaintId= complaint.getId();
        this.answerText=complaint.getComplaintText();
    }


    public Long getComplaintId() {
        return this.complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }



    public String getAnswerText() {
        return this.answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }



}