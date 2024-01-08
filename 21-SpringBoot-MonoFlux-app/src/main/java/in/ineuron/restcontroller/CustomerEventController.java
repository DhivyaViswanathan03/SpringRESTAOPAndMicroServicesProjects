package in.ineuron.restcontroller;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.CustomerEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class CustomerEventController {
	
	@GetMapping("/getEvent")
	public ResponseEntity<Mono<CustomerEvent>> getCustomerEvent(){
		CustomerEvent event=new CustomerEvent("Sachin", new Date());
		
		Mono<CustomerEvent> monoObj = Mono.just(event);
		return new ResponseEntity<Mono<CustomerEvent>>(monoObj, HttpStatus.OK);
	}
	
	@GetMapping(value="/getEvents",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ResponseEntity<Flux<CustomerEvent>> getCustomerEvents(){
		CustomerEvent event=new CustomerEvent("Sachin", new Date());
		Stream<CustomerEvent> customerStream = Stream.generate(()->event);
		Flux<CustomerEvent> customerFlux = Flux.fromStream(customerStream);
		Flux<Long> duration = Flux.interval(Duration.ofMillis(30000));
		Flux<Tuple2<Long, CustomerEvent>> zip = Flux.zip(duration, customerFlux);
		return new ResponseEntity<Flux<CustomerEvent>>(zip.map(Tuple2::getT2), HttpStatus.OK);
	}

}
