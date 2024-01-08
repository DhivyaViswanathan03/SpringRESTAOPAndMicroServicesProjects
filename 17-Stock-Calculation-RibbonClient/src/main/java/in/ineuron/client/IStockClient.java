package in.ineuron.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="STOCK-SERVICE")
@RibbonClient(name="STOCK-SERVICE")
public interface IStockClient {
	
	@GetMapping("/price/stockPrice/{companyName}")
	public ResponseEntity<Double> invokeStockPrice(@PathVariable String companyName);

}
