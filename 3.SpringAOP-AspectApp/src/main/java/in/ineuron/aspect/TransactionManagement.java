package in.ineuron.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionManagement {
	
	
	@Pointcut("execution(public * in.ineuron.dao.EmployeeDao.saveEmployee())")
	public void p1() {}
	

	
	 @Around("p1()")
	 public void aroundAdvice(ProceedingJoinPoint jp) {
		System.out.println("Before Transaction..");
		 try {
			Object obj=jp.proceed();
			System.out.println("Obj is:"+obj);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("After Transaction...");
	 }
	 



}
