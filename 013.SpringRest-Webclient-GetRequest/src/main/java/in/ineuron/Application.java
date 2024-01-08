package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.CurrencyServiceApp;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		CurrencyServiceApp service = context.getBean(CurrencyServiceApp.class);
		service.getCurrencyValueSync();
		System.out.println("**********");
		service.getCurrencyValueASync();
	}

}

