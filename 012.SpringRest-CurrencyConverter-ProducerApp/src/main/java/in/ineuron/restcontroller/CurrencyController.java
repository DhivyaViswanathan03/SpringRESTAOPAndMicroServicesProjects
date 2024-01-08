package in.ineuron.restcontroller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.response.CurrencyResponse;

@RestController
@RequestMapping(path="/api/currency")
public class CurrencyController {
	
	@GetMapping("/getCurrencyValue/from/{from}/to/{to}")
	public ResponseEntity<CurrencyResponse> getCurrencyValue(@PathVariable String from,
			@PathVariable String to){
		CurrencyResponse response=new CurrencyResponse();
		response.setCurrencyId(1);
		response.setCurrencyFrom(from);
		response.setCurrencyTo(to);
		response.setCurrencyValue(82);
		return new ResponseEntity<CurrencyResponse>(response, HttpStatus.OK);	
	}
	
//	@GetMapping(path = "/wish")
//	public ResponseEntity<String> wishMessage(){
//		LocalDateTime ldt=LocalDateTime.now();
//		int hour=ldt.getHour();
//		String body=null;
//		if(hour<12)
//			body="Good Morning";
//		else if(hour<16)
//			body="Good Noon";
//		else if(hour<20)
//			body="Good evening";
//		else
//			body="Good Night";
//		return new ResponseEntity<String>(body, HttpStatus.OK);
//		
//	}

}
