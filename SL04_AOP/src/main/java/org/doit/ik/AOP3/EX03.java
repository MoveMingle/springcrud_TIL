package org.doit.ik.aop3;

import org.doit.ik.aop.Calulator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EX03 {
	public static void main(String[] args) {
		//org.doit.aop2.[advice]패키지
		// 전후 LogPrintAroundAdvice  클래스 추가


		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("application-context3.xml");
		Calulator calc = ctx.getBean("calcProxy",Calulator.class);
		System.out.println(calc.add(4,2));
		System.out.println("=3 END =  ");
	}

	/*
	 * p 204 Charter  
	 *  어플케이션을 다양한 공통기능이 필요로 한다 
	 *   고유한 기능 앞에 해야될 작업들 
	 *   공통 기능들은 어떤 특정 모듈에서만 필요로 하는 것이 안니라 
	 *   어플리케이션 전반에 걸쳐 필요한 기능이다 
	 *    AOP 관점기능 
	 *    중복코드필터 
	 *    AOP
	 *    org.doit.aop 패키지 추가 
	 *    ㄴ EX01.java
	 *    ㄴ Calulator인터페이스 추가 +-* / 추상메소드 선
	 *     ㄴCalulatorimpl 클래스 구현
	 * */

}
