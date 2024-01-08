package in.ineuron;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.ineuron.config.model.customer.Customer;
import in.ineuron.config.model.product.Product;
import in.ineuron.repo.customer.ICustomerRepo;
import in.ineuron.repo.product.IProductRepo;

@SpringBootApplication
public class Application  implements CommandLineRunner{
	
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private IProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepo.saveAll(Arrays.asList(
				new Customer(10,"divs","eriyur"),
				new Customer(11,"priya","kaleri"),
				new Customer(12,"mouli","banagalore")));
		
		productRepo.saveAll(Arrays.asList(
				new Product(101,"P-01","p001"),
				new Product(102,"P-02","p002"),
				new Product(103,"P-03","p003")
				));
	}

}
