package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class WishController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMsg(){
		String portNo=environment.getProperty("local.server.port");
		String msg="Welcome iNeuron";
		msg=msg.concat("Server is running on port no:"+portNo);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
