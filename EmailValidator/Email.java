package EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {
	String emailAddress;
	
	public Email(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public boolean isValid() throws Exception {
		String regex = "^[a-zA-Z0-9_.+-]+@company.com$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(this.emailAddress);
		if(!matcher.matches()) {
			throw new Exception("Email not valid");
		}
		return true;
	}
}
