package edu.mum.cs544.component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());

    @After("execution(* edu.mum.cs544.component.EmailSender.*(..))")
    public void logAfter(JoinPoint joinpoint) {
        logger.warn("method= " + joinpoint.getSignature().getName() + " address= " + joinpoint.getArgs()[0] + " message= " + joinpoint.getArgs()[1] +
                " outgoing mail server= " + ((EmailSender)joinpoint.getTarget()).getOutgoingMailServer());
    }

    @Around("execution(* edu.mum.cs544.dao.ICustomerDAO.save(..))")
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