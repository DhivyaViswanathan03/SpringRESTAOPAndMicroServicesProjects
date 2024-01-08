package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/greet")
public class SampleController {
	
	@GetMapping("/wish/{name}")
	public ResponseEntity<String> generateWishMessage(@PathVariable String name){
		LocalDateTime date = LocalDateTime.now();
		int hour=date.getHour();
		String msg=null;
		if(hour<12) {
			msg= "GM:"+name;
		}else if(hour<16) {
			msg="GN:"+name;
		}else if(hour<18) {
			msg="GE:"+name;
		}else {
			msg="GNight:"+name;
		}
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}

}
