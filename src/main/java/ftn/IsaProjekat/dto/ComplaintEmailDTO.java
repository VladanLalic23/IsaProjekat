package ftn.IsaProjekat.dto;

import ftn.IsaProjekat.model.clinic.Complaint;

public class ComplaintEmailDTO {
    private String donorEmail;
    private String answerText;


    public ComplaintEmailDTO() {
    }

    public ComplaintEmailDTO(String donorEmail, String answerText) {
        this.donorEmail = donorEmail;
        this.answerText = answerText;
    }

    public ComplaintEmailDTO(Complaint complaint)
    {
        this.donorEmail= complaint.getDonor().getEmail();
        this.answerText=complaint.getComplaintText();
    }

    public String getDonorEmail() {
        return this.donorEmail;
    }

    public void setDonorEmail(String donorEmail) {
        this.donorEmail = donorEmail;
    }

    public String getAnswerText() {
        return this.answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

}
