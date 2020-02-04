package controller.endpoint;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.message.EndpointMessageBase;
import common.message.GetUnknownPasswordResponse;
import common.message.LoginCreation;
import common.message.LoginCreationResponse;
import common.message.LoginRequest;
import common.message.LoginResponse;
import common.message.UpdatePassword;
import common.message.UpdatePasswordResponse;
import common.message.UpdateUnknownPassword;
import manager.login.LoginManager;

/**
 * endpoint for account management
 * login, update pass, ect
 * @author jravi
 *
 */
@RestController
public class PasswordController {

	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Used when a user wants to log into the application, 
	 * @param loginRequest - POST data from the front end application
	 * @return - success and a login token to use for future messages 
	 */
	@PostMapping("/login")
	public LoginResponse logInUser(@RequestBody LoginRequest loginRequest) {
		System.out.println("got loginRequest:" + loginRequest.userName + " " + loginRequest.password);
		
		LoginManager manager = new LoginManager();
		manager.validateLoginRequest(loginRequest);
		
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
	
	/**
	 * used to update password when pasword is known
	 * @param updatePassword
	 * @return
	 */
	@PostMapping("/password/update")
	public UpdatePasswordResponse updatePassword(@RequestBody UpdatePassword updatePassword) {
		System.out.println("got loginRequest:" + updatePassword.userName + " " + updatePassword.newPassword
				+ " " + updatePassword.oldPassword + " " + updatePassword.token);
		
		LoginManager manager = new LoginManager();
		manager.validatePasswordUpdate(updatePassword);
		
		UpdatePasswordResponse resp = new UpdatePasswordResponse();
		resp.messageSuccess =true;
		return resp;
	}
	
	/**
	 * used to update password when password is NOT known
	 * used to get the challenge question
	 * @param updatePassword
	 * @return
	 */
	@GetMapping("/password/unknown/{userId}")
	public GetUnknownPasswordResponse getUnknownPasswordInformatino(@PathVariable String userId) {
		System.out.println("got loginRequest:" + userId );
		
		LoginManager manager = new LoginManager();
		manager.validateUnknownPasswordInfo(userId);
		
		GetUnknownPasswordResponse resp = new GetUnknownPasswordResponse();
		resp.messageSuccess =true;
		return resp;
	}
	
	/**
	 * used to update password when password is NOT known
	 * submit challenge and change info
	 * @param updatePassword
	 * @return
	 */
	@PostMapping("/password/unknown")
	public EndpointMessageBase updateUnknownPassword(@RequestBody UpdateUnknownPassword updatePassword) {
		System.out.println("got loginRequest:" + updatePassword.challengeAnswer + " " + updatePassword.newPassword
				+ " " + updatePassword.username );
		
		LoginManager manager = new LoginManager();
		manager.validateUnknownPasswordUpdate(updatePassword);
		
		EndpointMessageBase resp = new EndpointMessageBase();
		resp.messageSuccess =true;
		return resp;
	}
}