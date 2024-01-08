package in.ineuron.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@GetMapping("info/{id}")//course/info/5
	public ResponseEntity<String> getCourseData(@PathVariable Integer id){
		String body=null;
		if(id==5)
			body="Welcome sachin";
		else if(id==6)
			body="Welcome Dhoni";
		else
			body="Welome Someone";
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}
	
	@GetMapping("info/{id}/demo/{name}")//course/info/5/demo/divs
	public ResponseEntity<String> getCourseDetails(@PathVariable Integer id,
			@PathVariable String name){
		String body=null;
		if(id==5 && name.equalsIgnoreCase("divs"))
			body="Welcome sachin";
		else if(id==6 && name.equalsIgnoreCase("priya"))
			body="Welcome Dhoni";
		else
			body="Welome Someone";
		return new ResponseEntity<String>(body,HttpStatus.OK);
	}

}
