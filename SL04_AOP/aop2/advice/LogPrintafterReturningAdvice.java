package org.doit.ik.AOP2.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class LogPrintafterReturningAdvice implements 
AfterReturningAdvice{

	@Override
	public void afterReturning(
			Object returnValue,// 결과값 
			Method method,//메서드
			Object[] args, //매개변수
			Object target)//대상 객체
					throws Throwable {
		String methodName = method.getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(">>"+ methodName + "() LogPrintReturninAdvice.호출됨....");
		
	}
}
	