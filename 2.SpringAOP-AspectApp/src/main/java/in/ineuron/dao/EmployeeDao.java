package in.ineuron.dao;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
//	public void saveEmployee() {
//		if(new Random().nextInt(10)<10) {
//			throw new RuntimeException("Dummy Exception..");
//		}
//		System.out.println("EmployeeDao.saveEmployee()");
//	}
//	
	public String saveEmployee() {
		
		return "EmployeeDao is saved with id 5";
	}
	


}
