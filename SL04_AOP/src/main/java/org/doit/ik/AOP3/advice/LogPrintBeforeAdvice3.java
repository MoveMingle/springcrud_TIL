package org.doit.ik.aop3.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class LogPrintBeforeAdvice3  implements MethodBeforeAdvice{

	@Override
	public void before(Method method  // add()
			, Object[] args   // 4,2 
			, Object target // 대상객체(실제 객체 clac)
			) throws Throwable {
	
		String methodName = method.getName();
		Log log=   LogFactory.getLog(this.getClass());
		log.info(">"+methodName+":LogPrintBeforeAdvice호출됨3..");	
		
		
	}//before

	
	
}//class
