package controller.endpoint;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.message.EndpointMessageBase;
import common.message.LoginCreation;
import common.message.LoginCreationResponse;
import common.message.LoginRequest;
import common.message.LoginResponse;
import common.message.UpdatePassword;
import common.message.UpdatePasswordResponse;
import manager.login.LoginManager;

/**
 * endpoint for account management
 * login, update pass, ect
 * @author jravi
 *
 */
@RestController
public class AccountController {

	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Used when a user wants to log into the application, 
	 * @param loginRequest - POST data from the front end application
	 * @return - success and a login token to use for future messages 
	 */
	@PostMapping("/login")
	public LoginResponse logInUser(@RequestBody LoginRequest loginRequest) {
		System.out.println("got loginRequest:" + loginRequest.userName + " " + loginRequest.password);
		LoginResponse resp = new LoginResponse();
		resp.token = "1234";
		resp.messageSuccess =true;
		return resp;
	}
	
	/**
	 * Used to create a new user login
	 * @param loginCreation - PUT data from the front end with login creation information
	 * @return success response
	 */
	@PutMapping("/login")
	public LoginCreationResponse createLogin(@RequestBody LoginCreation loginCreation) {
		System.out.println("got loginRequest:" + loginCreation.userName + " " + loginCreation.password +
				" " + loginCreation.email + " " + loginCreation.challengeQuestion + " " + loginCreation.challengeResponse);
		
		LoginManager manager = new LoginManager();
		manager.validateLoginCreation(loginCreation);
		
		LoginCreationResponse resp = new LoginCreationResponse();
		resp.messageSuccess =true;
		return resp;
	}
	
	@PostMapping("/password/update")
	public UpdatePasswordResponse updatePassword(@RequestBody UpdatePassword updatePassword) {
		System.out.println("got loginRequest:" + updatePassword.userName + " " + updatePassword.newPassword
				+ " " + updatePassword.oldPassword + " " + updatePassword.token);
		UpdatePasswordResponse resp = new UpdatePasswordResponse();
		resp.messageSuccess =true;
		return resp;
	}
}