package ftn.IsaProjekat.model.users;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
    
    @Column(name="email", unique = true)
    private String email;
    
    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name = "isActivated", nullable = false)
	private boolean isActivated;

    @Column(name = "initialPasswordChanged", nullable = false)
	private boolean initialPasswordChanged;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
	private Gender gender;

    @Column (name="phone") 
    private String phone;

    @Column(name="profession")
    private String profession;

    @Column(name="info")
    private String info;

    @Column(name = "jbmg")
    private Long jbmg;

    @Column(name = "last_password_reset_date")
	private Timestamp lastPasswordResetDate;

    @Embedded
	private Address address;


    public User() {
    }


    public User(Long id, Role role, String email, String password, String name, String surname, boolean isActivated, boolean initialPasswordChanged, Gender gender, String phone, String profession, String info, Long jbmg, Timestamp lastPasswordResetDate, Address address) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isActivated = isActivated;
        this.initialPasswordChanged = initialPasswordChanged;
        this.gender = gender;
        this.phone = phone;
        this.profession = profession;
        this.info = info;
        this.jbmg = jbmg;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.address = address;
    }




    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isIsActivated() {
        return this.isActivated;
    }

    public boolean getIsActivated() {
        return this.isActivated;
    }

    public void setIsActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public boolean isInitialPasswordChanged() {
        return this.initialPasswordChanged;
    }

    public boolean getInitialPasswordChanged() {
        return this.initialPasswordChanged;
    }

    public void setInitialPasswordChanged(boolean initialPasswordChanged) {
        this.initialPasswordChanged = initialPasswordChanged;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getJbmg() {
        return this.jbmg;
    }

    public void setJbmg(Long jbmg) {
        this.jbmg = jbmg;
    }

    public Timestamp getLastPasswordResetDate() {
        return this.lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    
}
