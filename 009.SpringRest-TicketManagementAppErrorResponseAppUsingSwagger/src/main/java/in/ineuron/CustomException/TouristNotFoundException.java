package in.ineuron.CustomException;

public class TouristNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
 public TouristNotFoundException(String message) {
	 super(message);
 }
}
