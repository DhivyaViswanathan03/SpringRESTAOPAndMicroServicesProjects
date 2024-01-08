//package in.ineuron.runner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//import in.ineuron.model.Actor;
//
//
//@Component
//public class ActorServiceConsumingRunner_GettingJSON implements CommandLineRunner{
//	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("ActorServiceConsumingRunner_GettingJSON.run()");
//		RestTemplate template=new RestTemplate();
//		String url="http://localhost:9999/10-SpringRest-ProducerApp/api/actor/find/{id}";
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("id", 12);
//		
//		
//		ResponseEntity<Actor> responseEntity = template.getForEntity(url, Actor.class, map);
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getStatusCodeValue());
//		System.out.println(responseEntity.getStatusCode());
//		
//	}
//
//}
