package in.ineuron.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUIService {
	
	private static final String REST_END_POINT = "http://localhost:4444/api/calc/calc/calculate/{companyName}/{quantity}";

	public String getCost(String companyName,Integer quantity) {
		String response=null;
		try {
			WebClient client=WebClient.create();
			response = client
					.get()
					.uri(REST_END_POINT, companyName,quantity)
					.retrieve()
					.bodyToMono(String.class)
					.block();
		} catch (Exception e) {
			response="Company not found";
		}
		return response;
	}

}
