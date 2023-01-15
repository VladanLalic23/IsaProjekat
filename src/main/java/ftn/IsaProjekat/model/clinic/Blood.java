package ftn.IsaProjekat.model.clinic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Blood {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name="bloodType")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    @Column(name="quantity")
    private long quantity;


    public Blood() {
    }


    public Blood(long id, BloodType bloodType, long quantity) {
        super();
        this.id = id;
        this.bloodType = bloodType;
        this.quantity = quantity;
    }



    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BloodType getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    
}
