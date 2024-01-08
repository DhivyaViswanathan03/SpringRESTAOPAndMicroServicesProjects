package in.ineuron.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	
	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.saveEmployee())")
	public void p1() {}
	
	@Before("p1()")
	public void beginTransaction() {
		System.out.println("TransactionManagement.beginTransaction()");
	}
	
	@AfterThrowing(value = "p1()",throwing = "obj")
	public void rollback(Throwable obj) {
		System.out.println("Transaction is rollbacked "+obj.getMessage());
	}
	
	@AfterReturning(value="p1()",returning = "obj")
	public void commitTransaction(Object obj) {
		System.out.println("TransactionManagement.commitTransaction()"+obj);
	}
	
	@After("p1()")
	public void emailCredentials() {
		System.out.println("Emailsetup is done");
	}

}
