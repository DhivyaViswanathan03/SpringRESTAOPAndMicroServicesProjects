package in.ineuron.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@Service
public class TicketServiceApp {
	
	private static String END_POINT="http://localhost:8081/3.SpringRest-TicketBooking-ProviderApp/api/ticket/register";
	
	public void invokeRestApi() {
		PassengerInfo body=new PassengerInfo();
		body.setPassengerFirstName("dhivya");
		body.setPassengerLastName("Viswa");
		body.setFrom("Bengaluru");
		body.setTo("pune");
		body.setJourneyDate("20/06/2023");
		
		WebClient webclient=WebClient.create();
		Ticket response=webclient.post()
		.uri(END_POINT)
		.accept(org.springframework.http.MediaType.APPLICATION_JSON)
		.bodyValue(body)
		.retrieve()
		.bodyToMono(Ticket.class).block();
		System.out.println(response);
		
	}


}
