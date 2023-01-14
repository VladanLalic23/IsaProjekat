package ftn.IsaProjekat.model.users;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)

public class User implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
    
    @Column(name="email", unique = true , updatable = false, nullable = false)
    private String email;
    
    @Column(name="password",nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surname",nullable = false)
    private String surname;

    @Column(name = "isActivated", nullable = false)
	private boolean isActivated;

    @Column(name = "initialPasswordChanged", nullable = false)
	private boolean initialPasswordChanged;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
	private Gender gender;

    @Column (name="phone",nullable = false) 
    private String phone;

    @Column(name="profession",nullable = false)
    private String profession;

    @Column(name="info",nullable = false)
    private String info;

    @Column(name = "jmbg",nullable = false,unique = true)
    private String jmbg;

    @Column(name = "last_password_reset_date")
	private Timestamp lastPasswordResetDate;

    @Embedded
	private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
	private List<Authority> authorities;


    public User() {
    }


    public User(Long id, Role role, String email, String password, String name, String surname, boolean isActivated, boolean initialPasswordChanged, Gender gender, String phone, String profession, String info, String jmbg, Timestamp lastPasswordResetDate, Address address) {
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
        this.jmbg = jmbg;
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



    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<Authority> authorities = new ArrayList<>();
        Authority authority = new Authority();
        authority.setName(role.name());
        authorities.add(authority);
        return authorities;
	}

    public String getJmbg() {
        return this.jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }


    @Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

    @Override
	public boolean isEnabled() {
		return isActivated;
	}

    
}
