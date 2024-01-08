package in.ineuron.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Customer;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@GetMapping("/report/{id}")
	public ResponseEntity<Customer> showCustomer(@PathVariable Integer id){
		Customer c=new Customer();
		c.setCno(id);
		c.setCname("Dhivya");
		c.setBillamount(10.0f);
		c.setTechs(new String[] {"java","spring","c"});
		c.setCountries(List.of("IND","PAK","US"));
		c.setPhonenumbers(Set.of(999984L,6564684L,5857845L));
		c.setIdDetails(Map.of("pan",98579895L,"Aadhar","DHCGDT8"));
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer customer){
		System.out.println(customer);
		Integer id=13;
		String body="Customer registered with id:"+id;
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}
