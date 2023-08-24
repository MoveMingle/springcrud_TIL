package org.doit.ik.AOP5.advice;

import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component("logPrintProfiler5")
@Aspect
public class LogPrintProfiler5 {
	@Pointcut("execution(* org.doit.ik.aop..*.*(*,*))")
	public void publicMethod(){}
	/*
	 * <aop:pointcut expression="execution(*s org.doit.ik.aop..*.*(*,*))"
	 * id="publicMethod" />
	 */
@Around("publicMethod()")
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
	@Before("publicMethod()")
    // 2. BeforeAdvice  p.217
    public void before(JoinPoint joinpoint) {
          String methodName = joinpoint.getSignature().toShortString();
       
       Log log = LogFactory.getLog(this.getClass());
       log.info(">>>" + methodName + "() : LogPrintProfiler4.before가 호출됨...");
    }
	@After("publicMethod()")
    // 3. AfterAdvice  p.221
    public void afterFinally(JoinPoint joinpoint) {
       String methodName = joinpoint.getSignature().toShortString();
    
    Log log = LogFactory.getLog(this.getClass());
    log.info(">>>" + methodName + "() : LogPrintProfiler4.afterfinally가 호출됨...");
 }

	
	
}