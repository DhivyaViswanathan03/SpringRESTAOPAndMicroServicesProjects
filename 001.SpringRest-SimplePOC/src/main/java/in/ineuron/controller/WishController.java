package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/wish")
public class WishController {
	
	@GetMapping("/msg")
	@ResponseBody
	public ResponseEntity<String> generateWishMessage(){
		String body=null;
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour<12)
			body= "Good Morning";
		else if(hour<16)
			body= "Good Noon";
		else if(hour<18)
			body= "Good Evening";
		else
			body= "Good Night";
		
		ResponseEntity<String> entity=new ResponseEntity<String>(body, HttpStatus.OK);
		
		return entity;
	}

}
