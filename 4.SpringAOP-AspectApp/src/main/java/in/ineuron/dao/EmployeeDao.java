package in.ineuron.dao;

import org.springframework.stereotype.Component;

import in.ineuron.annotation.MyTransaction;

@Component
public class EmployeeDao {
	
//	public void saveEmployee() {
//		if(new Random().nextInt(10)<10) {
//			throw new RuntimeException("Dummy Exception..");
//		}
//		System.out.println("EmployeeDao.saveEmployee()");
//	}
//	
	@MyTransaction
	public void saveEmployee() {
		System.out.println("Save method is called..");
	
	}
	


}
