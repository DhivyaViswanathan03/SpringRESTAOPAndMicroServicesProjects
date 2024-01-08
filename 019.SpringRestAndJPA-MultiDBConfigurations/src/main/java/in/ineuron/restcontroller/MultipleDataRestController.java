package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.config.model.customer.Customer;
import in.ineuron.config.model.product.Product;
import in.ineuron.repo.customer.ICustomerRepo;
import in.ineuron.repo.product.IProductRepo;

@RestController
@RequestMapping("/api")
public class MultipleDataRestController {
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private IProductRepo productRepo;
	
	@GetMapping("/customer")
	public List<Customer> findAllCustomer(){
		return customerRepo.findAll();
	}
	
	@GetMapping("/product")
	public List<Product> findAllProduct(){
		return productRepo.findAll();
	}
}
