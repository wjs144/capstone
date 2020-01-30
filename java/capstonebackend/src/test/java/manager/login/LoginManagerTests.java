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

}
