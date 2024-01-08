package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import in.ineuron.service.IStockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceRestController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private IStockPriceService service;
	
	@GetMapping("/stockPrice/{companyName}")
	public ResponseEntity<Double> getStockPrice(@PathVariable String companyName){
		System.out.println("Environment running on port is:"+env.getProperty("local.server.port"));
		Double price=service.findByCompanyName(companyName);
		System.out.println(companyName+":"+price);
		return new ResponseEntity<Double>(price,HttpStatus.OK);
	}
	

}
