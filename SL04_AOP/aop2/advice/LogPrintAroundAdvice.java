package org.doit.ik.AOP2.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class LogPrintAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		String methodName = method.getMethod().getName();
		Log log = LogFactory.getLog(this.getClass());
		log.info(methodName + "() start");
		StopWatch sw = new StopWatch();
		sw.start();
		Object result = method.proceed();
		sw.stop();
		log.info(methodName + "() end.");
		return result;
	}

}