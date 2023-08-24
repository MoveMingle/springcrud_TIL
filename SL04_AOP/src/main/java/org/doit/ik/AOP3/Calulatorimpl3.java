package org.doit.ik.aop3;

import javax.inject.Named;

import org.doit.ik.aop.Calulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("calc")
public class Calulatorimpl3 implements Calulator {

	@Override
	public int add(int x, int y) {
		//보조기능 장착
		//전                     공통관심사항 제거
		int result  = x+y; //핵심관심 사항(core concern)
		//후

		return result;
	}

	@Override
	public int sub(int x, int y) {
		//전
		int result  = x-y; //핵심관심 사항(core concern)
		//후

		return result;
	}

	@Override
	public int mult(int x, int y) {
		//전
		int result  = x*y; //핵심관심 사항(core concern)
		//후


		return result;
	}

	@Override
	public int div(int x, int y) {
		//전
		int result  = x/y; //핵심관심 사항(core concern)
		//후

		return result;
	}

}
