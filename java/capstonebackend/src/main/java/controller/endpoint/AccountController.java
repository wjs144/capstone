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

/**
 * endpoint for account management
 * login, update pass, ect
 * @author jravi
 *
 */
@RestController
public class AccountController {

	private final AtomicLong counter = new AtomicLong();
	
	@PostMapping("/login")
	public LoginResponse logInUser(@RequestBody LoginRequest loginRequest) {
		System.out.println("got loginRequest:" + loginRequest.userName + " " + loginRequest.password);
		LoginResponse resp = new LoginResponse();
		resp.token = "1234";
		resp.messageSuccess =true;
		return resp;
	}
	
	@PutMapping("/login")
	public LoginCreationResponse createLogin(@RequestBody LoginCreation loginCreation) {
		System.out.println("got loginRequest:" + loginCreation.userName + " " + loginCreation.password +
				" " + loginCreation.email + " " + loginCreation.challengeQuestion + " " + loginCreation.challengeResponse);
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