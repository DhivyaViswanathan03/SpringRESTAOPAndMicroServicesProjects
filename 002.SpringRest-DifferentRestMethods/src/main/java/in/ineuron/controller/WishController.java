package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishController {
	
	@GetMapping("/msg")
	public ResponseEntity<String> getMessage(){
		return new ResponseEntity<String>("getMethod",HttpStatus.OK);
	}
	@PostMapping("/msg")
	public ResponseEntity<String> registerMessage(){
		return new ResponseEntity<String>("postMethod",HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateMessage(){
		return new ResponseEntity<String>("updateMethod",HttpStatus.OK);
	}
	@DeleteMapping("/msg")
	public ResponseEntity<String> deleteMessage(){
		return new ResponseEntity<String>("deleteMethod",HttpStatus.OK);
	}
	
	@PatchMapping("/msg")
	public ResponseEntity<String> pUpdateMessage(){
		return new ResponseEntity<String>("partialUpdateMethod",HttpStatus.OK);
	}
	

}
