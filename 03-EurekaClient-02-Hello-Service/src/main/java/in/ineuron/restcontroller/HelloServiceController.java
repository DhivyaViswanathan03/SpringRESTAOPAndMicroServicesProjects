package in.ineuron.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceController {
	
	@GetMapping("/hello/{name}")
	public String hiMsg(@PathVariable("name") String name) {
		return "hello "+name;
	}

}
