package manager.login;

import java.util.regex.Pattern;

import common.message.EndpointMessageBase;
import common.message.ErrorMessageBase;
import common.message.LoginCreation;

public class LoginManager {
	
	public LoginManager()
	{}
	
	public ErrorMessageBase validateLoginCreation(LoginCreation loginCreation) {
		ErrorMessageBase message = new ErrorMessageBase();

		validateUsername(loginCreation.userName, message);
		
		return message;
	}

	void validateUsername(String userName, ErrorMessageBase message) {
		if(userName == null) {
			message.errorMsg.add("Username is Null");
			message.messageSuccess = false;
		}
		else if(userName.length() == 0) {
			message.errorMsg.add("Username is blank");
			message.messageSuccess = false;
		}
		else {
			boolean value = userName.matches("\\w+");
			System.out.println(value);
			if(! value ) {
				message.errorMsg.add("Username contains invalid characters:"+userName);
				message.messageSuccess = false;
			} 
		}
		
	}

}
