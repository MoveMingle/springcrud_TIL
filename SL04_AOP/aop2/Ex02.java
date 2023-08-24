package org.doit.ik.AOP2;

import org.doit.ik.AOP.Calculator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Ex02 {

   public static void main(String[] args) {
      // org.doit.il.aop2.[advice] 패키지 - 언제
      //전후       LogPointAroundAdvice 클래스 추가
      GenericXmlApplicationContext ctx = new GenericXmlApplicationContext
         ("application-context2.xml");
            //Calculator calc = ctx.getBean("calc", Calculator.class);
            
            Calculator calc = ctx.getBean("calcProxy", Calculator.class);
            System.out.println(calc.add(4, 2));
               
      System.out.println("= 2 END =");
      
      
   } //main

}