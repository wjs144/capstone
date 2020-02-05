package com.controller.endpoint;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import common.message.EndpointMessageBase;

@RestController
public class EventController {

	@GetMapping("/event")
	public EndpointMessageBase getEventInformation() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
	
	@PostMapping("/event")
	public EndpointMessageBase updateEvent() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
	
	@PutMapping("/event")
	public EndpointMessageBase newEvent() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
	
	@DeleteMapping("/event")
	public EndpointMessageBase removeEvent() {
		
		EndpointMessageBase resp = new EndpointMessageBase();
		
		resp.errorMsg =  new String[] {("Im an error msg") };
		resp.messageSuccess =true;
		return resp;
	}
}
