//package in.ineuron.runner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//
//
//@Component
//public class ActorServiceConsumingRunner_PathVariable implements CommandLineRunner{
//	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("ActorServiceConsumingRunner_PathVariable.run()");
//		RestTemplate template=new RestTemplate();
//		String url="http://localhost:9999/10-SpringRest-ProducerApp/api/actor/wish/{id}/{name}";
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("id", 7);
//		map.put("name", "divs");
//		ResponseEntity<String> responseEntity = template.getForEntity(url, String.class,map);
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getStatusCodeValue());
//		System.out.println(responseEntity.getStatusCode());
//		
//	}
//
//}
