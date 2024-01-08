package in.ineuron.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	public void saveEmployee() {
		System.out.println("EmployeeDao.saveEmployee()");
	}
	
	public void deleteEmployee() {
		System.out.println("EmployeeDao.deleteEmployee()");
	}
	public void getEmployee() {
		System.out.println("EmployeeDao.getEmployee()");
	}

}
