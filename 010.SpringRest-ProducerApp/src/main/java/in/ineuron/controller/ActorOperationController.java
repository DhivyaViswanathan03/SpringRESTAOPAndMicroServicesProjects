package in.ineuron.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Actor;

@RestController
@RequestMapping("/api/actor")
public class ActorOperationController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> wishMessage(){
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		String body=null;
		if(hour<12)
			body="Good Morning";
		else if(hour<16)
			body="Good Noon";
		else if(hour<20)
			body="Good evening";
		else
			body="Good Night";
		return new ResponseEntity<String>(body, HttpStatus.OK);
		
	}
	
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id,@PathVariable String name){
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		String body=null;
		if(hour<12)
			body="Good Morning "+name+" associated with id:"+id;
		else if(hour<16)
			body="Good Noon "+name+" associated with id:"+id;
		else if(hour<20)
			body="Good evening "+name+" associated with id:"+id;
		else
			body="Good Night "+name+" associated with id:"+id;
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor data is:"+actor.toString(),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Actor> findActor(@PathVariable Integer id){
		return new ResponseEntity<Actor>(new Actor(id, "priya", 32.1f, "tester"), HttpStatus.OK);
		
	}

}



