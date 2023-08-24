package org.doit.ik.AOP5;

import org.doit.ik.AOP.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex05 {

   public static void main(String[] args) {
	   
		/* p226 @Aspect 어노테시션 기반의 AOP구현하는 방법 */
	   
      // org.doit.il.aop2.[advice] 패키지 - 언제
      //전후       LogPointAroundAdvice 클래스 추가
      GenericXmlApplicationContext ctx = new GenericXmlApplicationContext
         ("application-context5.xml");
            //Calculator calc = ctx.getBean("calc", Calculator.class);
            //스프링 aop
            Calculator calc = ctx.getBean("calc5", Calculator.class);
            System.out.println(calc.add(4, 2));
               
      System.out.println("= 5 END =");
      
      
   } //main

}