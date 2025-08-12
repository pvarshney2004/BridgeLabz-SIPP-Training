package EmailValidator;

public class Employee {
	String name;
	Email email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public String toString() {
		return name+" -> "+email.getEmailAddress();
	}
}
