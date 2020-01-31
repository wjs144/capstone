package manager.login;

import common.message.ErrorMessageBase;
import common.message.LoginCreation;

public class LoginManager {
	
	public LoginManager()
	{}
	
	public ErrorMessageBase validateLoginCreation(LoginCreation loginCreation) {
		ErrorMessageBase message = new ErrorMessageBase();

		validateUsername(loginCreation.userName, message);
		validatePassword(loginCreation.password, message);
		validateChallengeQuestion(loginCreation.challengeQuestion, message);
		//question and response have same validation rules
		validateChallengeQuestion(loginCreation.challengeResponse, message);
		validateEmail(loginCreation.email, message);

		return message;
	}

	void validateEmail(String email, ErrorMessageBase message) {
		// TODO Auto-generated method stub
		if(email == null) {
			message.errorMsg.add("email is Null");
			message.messageSuccess = false;
		}
		else if(email.length() == 0 || email.length() > 30) {
			message.errorMsg.add("email is the wrong length");
			message.messageSuccess = false;
		}
		else {
			boolean value = email.matches("[a-zA-Z0-9._]+[@][a-zA-Z0-9.]+");
			if(! value ) {
				message.errorMsg.add("email contains invalid characters:"+email);
				message.messageSuccess = false;
			} 
		}	
	}

	void validateChallengeQuestion(String challengeQuestion, ErrorMessageBase message) {
		if(challengeQuestion == null) {
			message.errorMsg.add("challenge is Null");
			message.messageSuccess = false;
		}
		else if(challengeQuestion.length() == 0 || challengeQuestion.length() > 30) {
			message.errorMsg.add("challenge is the wrong length");
			message.messageSuccess = false;
		}
		else {
			boolean value = challengeQuestion.matches("[a-zA-Z0-9!@#$%^& ]+");
			if(! value ) {
				message.errorMsg.add("challenge contains invalid characters:"+challengeQuestion);
				message.messageSuccess = false;
			} 
		}	
		
	}

	void validatePassword(String password, ErrorMessageBase message) {
		if(password == null) {
			message.errorMsg.add("password is Null");
			message.messageSuccess = false;
		}
		else if(password.length() == 0 || password.length() > 20) {
			message.errorMsg.add("password is the wrong length");
			message.messageSuccess = false;
		}
		else {
			boolean value = password.matches("[a-zA-Z0-9!@#$%^&]+");
			if(! value ) {
				message.errorMsg.add("Password contains invalid characters:"+password);
				message.messageSuccess = false;
			} 
		}		
	}

	void validateUsername(String userName, ErrorMessageBase message) {
		if(userName == null) {
			message.errorMsg.add("Username is Null");
			message.messageSuccess = false;
		}
		else if(userName.length() == 0 || userName.length() > 20) {
			message.errorMsg.add("Username is the wrong length");
			message.messageSuccess = false;
		}
		else {
			boolean value = userName.matches("\\w+");
			if(! value ) {
				message.errorMsg.add("Username contains invalid characters:"+userName);
				message.messageSuccess = false;
			} 
		}
		
	}

}
