package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.HelloClient;

@RestController
public class HiServiceController {
	
	@Autowired
	private HelloClient client;
	
	@GetMapping("/hi/{name}")
	public String hiMsg(@PathVariable("name") String name) {
		System.out.println("impl class of client is:"+client.getClass().getName());
		String msg=client.invokeHelloService(name);
		return "hi "+name+msg;
	}

}
