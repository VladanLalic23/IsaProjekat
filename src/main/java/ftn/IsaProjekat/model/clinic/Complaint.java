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
	private int complaineeId;

	@Column
	private Boolean answered;

	public Complaint() {

	}

	public Complaint(long id, Donor donor, String complaintText, ComplaintType type, int complaineeId,
			Boolean answered) {
		super();
		this.id = id;
		this.donor = donor;
		this.complaintText = complaintText;
		this.type = type;
		this.complaineeId = complaineeId;
		this.answered = answered;

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

	public int getComplaineeId() {
		return this.complaineeId;
	}

	public void setComplaineeId(int complaineeId) {
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

	public Complaint id(long id) {
		setId(id);
		return this;
	}

	public Complaint donor(Donor donor) {
		setDonor(donor);
		return this;
	}

	public Complaint complaintText(String complaintText) {
		setComplaintText(complaintText);
		return this;
	}

	public Complaint type(ComplaintType type) {
		setType(type);
		return this;
	}

	public Complaint complaineeId(int complaineeId) {
		setComplaineeId(complaineeId);
		return this;
	}

	public Complaint answered(Boolean answered) {
		setAnswered(answered);
		return this;
	}

}
