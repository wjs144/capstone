package controller.endpoint;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import common.message.EndpointMessageBase;

/**
 * endpoint for account management
 * login, update pass, ect
 * @author jravi
 *
 */
@RestController
public class AccountController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/login")
	public EndpointMessageBase greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new EndpointMessageBase();
	}
}