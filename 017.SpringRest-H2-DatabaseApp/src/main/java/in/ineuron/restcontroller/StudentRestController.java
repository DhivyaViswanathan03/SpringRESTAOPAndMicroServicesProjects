package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import in.ineuron.model.Student;
import in.ineuron.service.IStudentService;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
	
	@Autowired
	private IStudentService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		String message=service.saveStudent(student);
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAllStudents(){
		List students=service.displayAllStudent();
		return new ResponseEntity<List<String>>(students, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> findStudentById(@PathVariable Integer id){
		Student student=service.findStudent(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		String message=service.updateStudent(student);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeStudentById(@PathVariable Integer id){
		String message=service.deleteStudent(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
