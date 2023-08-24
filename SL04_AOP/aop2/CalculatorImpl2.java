package org.doit.ik.AOP2;

import org.doit.ik.AOP.Calculator;

public class CalculatorImpl2 implements Calculator{

	@Override
	public int add(int x, int y) {
			//전 //공통 관심사항 제거
		int result = x+y; //핵심 관심 사항(core concern)
		//후	
		return result;
	}

	@Override
	public int sub(int x, int y) {
		//전
		int result = x-y;//핵심 관심 사항(core concern)
		//후
		return result;
	}

	@Override
	public int mult(int x, int y) {
		//전
		int result = x*y;//핵심 관심 사항(core concern)
		//후
		return result;
	}

	@Override
	public int div(int x, int y) {
		int result = x/y;//핵심 관심 사항(core concern)
		
		
		return result;
	}

	
}
