package in.ineuron.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	@Pointcut("execution(public void in.ineuron.dao.EmployeeDao.saveEmployee())")
	public void saveOperation() {
		
	}
	
	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.deleteEmployee())")
	public void deleteOperation() {
		
	}
	
	@Pointcut("saveOperation() || deleteOperation()")
	public void operation() {
		
	}
	
	@Before("operation()")
	public void beginTransaction() {
		System.out.println("TransactionManagement.beginTransaction()");
	}
	
	@After("operation()")
	public void commitTransaction() {
		System.out.println("TransactionManagement.commitTransaction()");
	}

}
