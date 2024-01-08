package in.ineuron.restcontroller;

import org.slf4j.Logger;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class WelcomeController {
	
	Logger logger=LoggerFactory.getLogger(WelcomeController.class);
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		logger.info("***** getWelcomeMsg() started******");
		String msg = "Welcome to ineuron";
		logger.info("**** getWelcomeMsg() ended *****");
		return msg;
	}
}
