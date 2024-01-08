package in.ineuron.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.service.IPhoneMgmtService;

@Component
public class AssociationRunner implements CommandLineRunner {

	@Autowired
	private IPhoneMgmtService service;

	@Override
	public void run(String... args) throws Exception {

		service.fetchDataUsingJoins().forEach(row -> {
			for (Object obj : row) {
				System.out.print(obj + " ");
			}
			System.out.println();
		});

	}

}
