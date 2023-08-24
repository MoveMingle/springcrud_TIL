package org.doit.ik.AOP2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

public class LogPrintBeforeAdvice implements 
MethodBeforeAdvice{

	@Override
	public void before(
			Method method //add(
			, Object[] args //add(4,2)
			, Object target) //대상 객체 필요(실제 객체 cal)
					throws Throwable {
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>"+ methodName + "() LogPrintBeforeAdvice.호출됨....");
		
		
		
	}//before

}//class
