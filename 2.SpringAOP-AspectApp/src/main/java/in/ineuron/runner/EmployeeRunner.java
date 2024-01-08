package in.ineuron.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.ineuron.dao.EmployeeDao;

@Component
public class EmployeeRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("EmployeeRunner.run()");
		dao.saveEmployee();
		
		
	}

}
