package org.doit.ik.AOP4;

import org.doit.ik.AOP.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex04 {

   public static void main(String[] args) {
	   
		/* p211 xml 설정 파일에 <aop:config>태그 이용해서 
		 * 1)Aspect 설정
		 * 2)Advice+어떤 pointcut 적용할지를 설정
		 *  */
	   
	   
      // org.doit.il.aop2.[advice] 패키지 - 언제
      //전후       LogPointAroundAdvice 클래스 추가
      GenericXmlApplicationContext ctx = new GenericXmlApplicationContext
         ("application-context4.xml");
            //Calculator calc = ctx.getBean("calc", Calculator.class);
            //스프링 aop
            Calculator calc = ctx.getBean("calc4", Calculator.class);
            System.out.println(calc.add(4, 2));
               
      System.out.println("= 4 END =");
      
      
   } //main

}