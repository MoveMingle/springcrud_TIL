package org.doit.ik.aop3.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
//대상객체가 핵심기능의 메서드를 예외없이 처리된 경우 호출되는 Advice
public class LogPrintAfterReturningAdvice3 implements AfterReturningAdvice{
	
	@Override
	public void afterReturning(Object returnValue, //결과값 예외없이 잘처리되는 결과값
			Method method,  // 메서드
			Object[] args, //매개변수
			Object target //대상객체
			) throws Throwable {
		String methodName	= method.getName();
		Log log=   LogFactory.getLog(this.getClass());
		log.info(">"+methodName+"LogPrintAfterReturningAdvice3 호출됨");	
		
		
	}//afterReturning

}//calss
