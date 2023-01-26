package ftn.IsaProjekat.model.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.IsaProjekat.model.users.Donor;

@Entity
@Table(name = "complaints")
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private Donor donor;

	@Column(name = "complaintText", nullable = false)
	private String complaintText;

	@Enumerated(EnumType.STRING)
	private ComplaintType type;

	@Column(name = "complaineeId", nullable = false)
	private Long complaineeId;

	@Column
	private Boolean answered;

	@Column
	private String answerText;


	public Complaint() {

	}

	public Complaint(long id, Donor donor, String complaintText, ComplaintType type, Long complaineeId,
			Boolean answered,String answerText) {
		super();
		this.id = id;
		this.donor = donor;
		this.complaintText = complaintText;
		this.type = type;
		this.complaineeId = complaineeId;
		this.answered = answered;
		this.answerText= answerText;

	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Donor getDonor() {
		return this.donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public String getComplaintText() {
		return this.complaintText;
	}

	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}

	public ComplaintType getType() {
		return this.type;
	}

	public void setType(ComplaintType type) {
		this.type = type;
	}

	public Long getComplaineeId() {
		return this.complaineeId;
	}

	public void setComplaineeId(Long complaineeId) {
		this.complaineeId = complaineeId;
	}

	public Boolean isAnswered() {
		return this.answered;
	}

	public Boolean getAnswered() {
		return this.answered;
	}

	public void setAnswered(Boolean answered) {
		this.answered = answered;
	}


	public String getAnswerText() {
		return this.answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}


}
