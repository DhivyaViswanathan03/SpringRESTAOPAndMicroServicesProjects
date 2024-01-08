package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@RestController
@RequestMapping("/api/ticket")
public class TicketRestController {
	
	@PostMapping("/register")
	public ResponseEntity<Ticket> postBookingDetails(@RequestBody PassengerInfo info){
		Ticket ticket=new Ticket();
		ticket.setTicketId("1");
		ticket.setPassengerFirstName(info.getPassengerFirstName());
		ticket.setPassengerLastName(info.getPassengerLastName());
		ticket.setFrom(info.getFrom());
		ticket.setTo(info.getTo());
		ticket.setJourneyDate(info.getJourneyDate());
		ticket.setStatus("booked");
		ticket.setTicketNumber("PNR100");
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}

}
