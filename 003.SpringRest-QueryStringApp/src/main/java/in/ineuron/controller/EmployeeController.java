package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@GetMapping("/msg")
	public ResponseEntity<String> getEmployee(@RequestParam(defaultValue = "1",required = false) Integer id,@RequestParam String name){
		String body=null;
		
		if(id==1 && name.equalsIgnoreCase("divs"))
			body="CUP";
		else if(id==2 && name.equalsIgnoreCase("priya"))
			body="PUP";
		else if(id==3 && name.equalsIgnoreCase("reka"))
			body="MYSORE";
			else
				body="Not valid input";
		return new ResponseEntity<String>("Employee id and name is:"+id+","+name +"location is:"+body,HttpStatus.OK);
	}
	
}
