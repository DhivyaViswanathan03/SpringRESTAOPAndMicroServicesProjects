package in.ineuron.RestController;

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
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {
	
	@Autowired
	private ITouristService service;
	
	@PostMapping("/register")
	@ApiOperation("To register Tourist Customer")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
			String resultMsg=service.registerTourist(tourist);
			return new ResponseEntity<String>(resultMsg,HttpStatus.OK);
		
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAllTourist(){
			List<Tourist> tourists=service.fetchAllTourist();
			return new ResponseEntity<List<Tourist>>(tourists,HttpStatus.OK);
		
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> fetchTouristById(@PathVariable Integer id){
			Tourist tourist=service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> modifyTouristDetails(@RequestBody Tourist tourist){
			String msg=service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@PatchMapping("/update/{id}/{hike}")
	public ResponseEntity<?> updateTouristHike(@PathVariable Integer id,@PathVariable("hike") Float hikeamt){
			String msg=service.updateTouristBudgetById(id, hikeamt);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTourist(@PathVariable Integer id){
			String msg=service.deleteTouristById(id);
			return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
