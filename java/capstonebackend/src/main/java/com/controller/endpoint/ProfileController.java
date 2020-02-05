package com.controller.endpoint;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import common.message.EndpointMessageBase;

@RestController
public class ProfileController {

	
	@GetMapping("/profile")
	public EndpointMessageBase getProfileInformation() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
	
	@PostMapping("/profile")
	public EndpointMessageBase updateProfile() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
	
	@PutMapping("/profile")
	public EndpointMessageBase newProfile() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
	
	@DeleteMapping("/profile")
	public EndpointMessageBase removeProfile() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
}
