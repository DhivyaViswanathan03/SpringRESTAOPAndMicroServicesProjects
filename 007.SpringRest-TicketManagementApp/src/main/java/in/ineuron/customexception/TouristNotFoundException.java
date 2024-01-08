package in.ineuron.customexception;

public class TouristNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
 public TouristNotFoundException(String message) {
	 super(message);
 }
}
