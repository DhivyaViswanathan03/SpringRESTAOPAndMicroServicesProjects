package in.ineuron.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class ActorServiceConsumingRunner implements CommandLineRunner{
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("ActorServiceConsumingRunner.run()");
		RestTemplate template=new RestTemplate();
		String url="http://localhost:8081/001.SpringRest-SimplePOC/api/actor/wish";
		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getStatusCodeValue());
		System.out.println(responseEntity.getStatusCode());
		System.out.println("****************************************");
		
	}

}
