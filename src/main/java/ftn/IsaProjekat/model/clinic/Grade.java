package ftn.IsaProjekat.model.clinic;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ftn.IsaProjekat.model.users.Donor;

@Entity
@Table(name="grade")

public class Grade {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Donor donor;
	
	@Column(name = "gradedId", nullable = false)
	private long gradedId;
	
	@Column(name = "grade", nullable = false)
	private int grade;


    public Grade() {
    }
 
    public Grade(long id, Donor donor, long gradedId, int grade) {
        super();
        this.id = id;
        this.donor = donor;
        this.gradedId = gradedId;
        this.grade = grade;
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

    public long getGradedId() {
        return this.gradedId;
    }

    public void setGradedId(long gradedId) {
        this.gradedId = gradedId;
    }

    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    
}
