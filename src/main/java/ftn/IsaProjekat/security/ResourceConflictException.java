package ftn.IsaProjekat.security;

public class ResourceConflictException extends RuntimeException{

	private static final long serialVersionUID = -6659702830853759767L;
	
	private String email;

	public ResourceConflictException(String email, String message) {
		super(message);
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}