package org.doit.ik.AOP4.advice;

import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("logPrintProfiler4")
public class LogPrintProfile4 {

	//AroundAdvice p222
	public Object trace(ProceedingJoinPoint joinPoint)throws
	Throwable{
	//BeforeAdvice 
		String methodName = joinPoint.getSignature().toShortString();
		Log log = LogFactory.getLog(this.getClass());
		log.info(methodName + "() start");
		StopWatch sw = new StopWatch();
		sw.start();
		Object result = joinPoint.proceed();
		sw.stop();
		log.info(methodName + "() end.");
		return result;
		
		
	//AfterAdvice

}
	
    // 2. BeforeAdvice  p.217
    public void before(JoinPoint joinpoint) {
          String methodName = joinpoint.getSignature().toShortString();
       
       Log log = LogFactory.getLog(this.getClass());
       log.info(">>>" + methodName + "() : LogPrintProfiler4.before가 호출됨...");
    }
    
    // 3. AfterAdvice  p.221
    public void afterFinally(JoinPoint joinpoint) {
       String methodName = joinpoint.getSignature().toShortString();
    
    Log log = LogFactory.getLog(this.getClass());
    log.info(">>>" + methodName + "() : LogPrintProfiler4.afterfinally가 호출됨...");
 }

	
	
}