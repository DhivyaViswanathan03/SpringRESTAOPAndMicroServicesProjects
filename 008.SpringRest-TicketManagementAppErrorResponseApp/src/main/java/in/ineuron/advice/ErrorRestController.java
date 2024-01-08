package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.customexception.TouristNotFoundException;
import in.ineuron.error.ErrorDetails;

@RestControllerAdvice
public class ErrorRestController {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> touristNotFoud(TouristNotFoundException t){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(), t.getMessage(), "not found");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> anotherProblems(Exception t){
		ErrorDetails details=new ErrorDetails(LocalDateTime.now(), t.getMessage(), "some other problems");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.INTERNAL_SERVER_ERROR);
	}

} 
