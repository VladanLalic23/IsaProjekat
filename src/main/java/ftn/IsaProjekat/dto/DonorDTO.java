package ftn.IsaProjekat.dto;
 
import ftn.IsaProjekat.model.users.User;

public class DonorDTO {
    private long id;
	private String name;
	private String surname;
	private String email;
    private boolean form;


    public DonorDTO() {
    }

    public DonorDTO(long id, String name, String surname, String email,boolean form) {
        super();
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.form=form;
    }

    public DonorDTO(User user) {
        super();
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.email = user.getEmail();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public boolean isForm() {
        return this.form;
    }

    public boolean getForm() {
        return this.form;
    }

    public void setForm(boolean form) {
        this.form = form;
    }

    
}
