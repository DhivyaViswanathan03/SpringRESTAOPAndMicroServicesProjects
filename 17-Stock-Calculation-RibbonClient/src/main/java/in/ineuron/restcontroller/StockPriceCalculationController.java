package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.client.IStockClient;

@RestController
@RequestMapping("/calc")
public class StockPriceCalculationController {
	
	@Autowired
	private IStockClient client;
	
	@GetMapping("/calculate/{companyName}/{quantity}")
	public ResponseEntity<?> calculate(@PathVariable String companyName,@PathVariable int quantity){
		ResponseEntity<?> responseEntity=null;
		try {
			responseEntity=client.invokeStockPrice(companyName);
			if(responseEntity.getStatusCode().value()==200) {
				Double companyStockPrice=(Double) responseEntity.getBody();
				double totalPrice=quantity*companyStockPrice;
				String response="Total cost is:"+totalPrice;
				responseEntity=new ResponseEntity<String>(response,HttpStatus.OK);
				
			}
		} catch (Exception e) {
			responseEntity=new ResponseEntity<String>("Company Not Found",HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	

}
