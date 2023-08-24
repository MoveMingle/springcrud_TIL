package org.doit.ik.AOP;

public class Ex01 {

	public static void main(String[] args) {
		/*
		 * p204 Chatpter06 스프링 AOP
		 */		
		
		/*
		 * ㄴcalulator 인터페이스
		 *  ㄴㄴcalulatorImpl 클래스 구현
		 */
		
		
		Calculator calc = new CalculatorImpl();
		System.out.println(calc.add(4, 2));
		System.out.println(calc.sub(4, 2));
		System.out.println(calc.mult(4, 2));
		System.out.println(calc.div(4, 2));
		System.out.println("= END =");
	}

}
