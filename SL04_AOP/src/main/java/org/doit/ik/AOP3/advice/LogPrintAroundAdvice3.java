package org.doit.ik.aop3.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
//보조기능을나타내는 어드바이스 
@Component
public class LogPrintAroundAdvice3 implements MethodInterceptor{
	
	// 스프링@AutowiredAOP: 메서드 호출
      //calc_add() 보조기능 장착+로그기록
	@Override
	public Object invoke(MethodInvocation  method) throws Throwable {
		
	String methodName	= method.getMethod().getName();
	Log log=   LogFactory.getLog(this.getClass());
	log.info(">"+methodName+"()start3.");	
	StopWatch sw = new StopWatch();
	sw.start();
	// 핵심관심사항
	 Object result =  method.proceed();//calc.add();
	 
	sw.stop();
    log.info(">" + methodName + "() end3.");
    log.info(">" + methodName + "() 처리 시간 : " + sw.getTotalTimeMillis() + "ms");
	return result;
	}

}
