package in.ineuron.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.response.CurrencyResponse;

@Service
public class CurrencyServiceApp {
	
	private static String END_POINT="http://localhost:8081/1.SpringRest-WebclientProducerApp/api/currency/getCurrencyValue/from/USD/to/INR";
	
	public void getCurrencyValueSync() {
		System.out.println("Syn method is called...");
		WebClient webclient=WebClient.create();
		CurrencyResponse response = webclient.get()
		         .uri(END_POINT)
		         .retrieve()
		         .bodyToMono(CurrencyResponse.class)
		         .block();
		System.out.println(response);
		System.out.println("Syn method is end...");
	}
	
	public void getCurrencyValueASync() {
		System.out.println("ASyn method is called...");
		WebClient webclient=WebClient.create();
		webclient.get()
		         .uri(END_POINT)
		         .retrieve()
		         .bodyToMono(CurrencyResponse.class)
		         .subscribe(CurrencyServiceApp::myResponse);
		System.out.println("ASyn method is end.....");
	}

	private static void myResponse(CurrencyResponse response) {
		System.out.println(response);
	}

}
