package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.constants.APIConstants;
import in.ineuron.props.DemoConfigProps;

@RestController
@RequestMapping("/api/test")
public class SampleRestController {

	@Autowired
	private DemoConfigProps props;
	
	@GetMapping("/greet")
	public String greetMsg() {
		return props.getProperties().get(APIConstants.GREET_MSG);
	}
	
	@GetMapping("/welcome")
	public String welcomeMsg() {
		return props.getProperties().get(APIConstants.WELCOME_MSG);
	}
	
	@GetMapping("/text")
	public String textMsg() {
		return props.getProperties().get(APIConstants.TEXT_MSG);
	}
}
