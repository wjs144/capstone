package manager.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import common.message.ErrorMessageBase;

class LoginManagerTests {

	@Test
	void testValidateUsername() {
		LoginManager manager = new LoginManager();
		ErrorMessageBase message = new ErrorMessageBase();
		
		manager.validateUsername("###", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;
		manager.validateUsername(null, message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateUsername("", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateUsername("aa", message);
		message.errorMsg.get(0);
		Assertions.assertTrue(message.messageSuccess);
	}
	
	@Test
	void testValidatePassword() {
		LoginManager manager = new LoginManager();
		ErrorMessageBase message = new ErrorMessageBase();
		

		message.messageSuccess = true;
		manager.validatePassword(null, message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validatePassword("", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validatePassword("aa", message);
		message.errorMsg.get(0);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;

		manager.validatePassword("aaAa!#@%$&^", message);
		message.errorMsg.get(0);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;

		manager.validatePassword("aaAa!#@%$&^-", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;
	}
	
	@Test
	void testValidateChallengeQuestion() {
		LoginManager manager = new LoginManager();
		ErrorMessageBase message = new ErrorMessageBase();
		
		message.messageSuccess = true;
		manager.validateChallengeQuestion(null, message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateChallengeQuestion("", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateChallengeQuestion("aa", message);
		message.errorMsg.get(0);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateChallengeQuestion("aaAa!#@%$&^", message);
		message.errorMsg.get(0);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateChallengeQuestion("hello yes", message);
		message.errorMsg.get(0);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateChallengeQuestion("aaAa!#@%$&^-", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;
	}
	
	@Test
	void testValidateEmail() {
		LoginManager manager = new LoginManager();
		ErrorMessageBase message = new ErrorMessageBase();
		
		message.messageSuccess = true;
		manager.validateEmail(null, message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateEmail("", message);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateEmail("aa", message);
		message.errorMsg.get(0);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateEmail("aaAa!#@%$&^", message);
		message.errorMsg.get(0);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateEmail("hello yes", message);
		message.errorMsg.get(0);
		Assertions.assertFalse(message.messageSuccess);
		message.messageSuccess = true;

		manager.validateEmail("bob@bob.com", message);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;
		
		manager.validateEmail("bob.bob_bob@bob.com", message);
		Assertions.assertTrue(message.messageSuccess);
		message.messageSuccess = true;
	}

}
