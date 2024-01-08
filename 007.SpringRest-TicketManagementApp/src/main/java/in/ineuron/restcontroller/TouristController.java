package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristService;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
	
	@Autowired
	private ITouristService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
			String resultMsg=service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Pblm in tourist enrollment",HttpStatus.NOT_FOUND);
		} 
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAllTourist(){
		try {
			List<Tourist> tourists=service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(tourists,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("Pblm in fetching tourits",HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchTouristById(@PathVariable Integer id){
		try {
			Tourist tourist=service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> modifyTouristDetails(@RequestBody Tourist tourist){
		try {
			String msg=service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/update/{id}/{hike}")
	public ResponseEntity<?> updateTouristHike(@PathVariable Integer id,@PathVariable("hike") Float hikeamt){
		try {
			String msg=service.updateTouristBudgetById(id, hikeamt);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTourist(@PathVariable Integer id){
		try {
			String msg=service.deleteTouristById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
