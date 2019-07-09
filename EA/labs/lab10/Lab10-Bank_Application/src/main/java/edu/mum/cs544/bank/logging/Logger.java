package edu.mum.cs544.bank.logging;

import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class Logger implements ILogger{

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class.getName());

	@After("execution(* edu.mum.cs544.bank..dao..*(..))")
	public void logAfter(JoinPoint joinpoint) {
		logger.warn("dao method executed: " + joinpoint.getSignature().getName());
	}

	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
	}

	@Around("execution(* edu.mum.cs544.bank..service..*(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute save = " + totaltime + "ms");
// print the time to the console
		return retVal;
	}

}
