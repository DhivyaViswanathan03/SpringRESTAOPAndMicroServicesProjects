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
//
//@Component
//public class ActorServiceConsumingRunner_PassingJSONInput implements CommandLineRunner{
//	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println("ActorServiceConsumingRunner_PassingJSONInput.run()");
//		RestTemplate template=new RestTemplate();
//		String url="http://localhost:9999/10-SpringRest-ProducerApp/api/actor/register";
//		HttpHeaders headers=new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		String JSON_DATA="{\r\n"
//				+ "    \"aid\":10,\r\n"
//				+ "    \"aname\":\"reka\",\r\n"
//				+ "    \"age\":12.1,\r\n"
//				+ "    \"type\":\"developer\"\r\n"
//				+ "}";
//		
//		HttpEntity request=new HttpEntity<>(JSON_DATA, headers);
//		
//		ResponseEntity<String> responseEntity = template.postForEntity(url, request, String.class);
//		System.out.println(responseEntity.getBody());
//		System.out.println(responseEntity.getStatusCodeValue());
//		System.out.println(responseEntity.getStatusCode());
//		
//	}
//
//}
