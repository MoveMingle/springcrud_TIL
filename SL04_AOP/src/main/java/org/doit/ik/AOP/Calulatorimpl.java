package org.doit.ik.aop;

public class Calulatorimpl implements Calulator {

	@Override
	public int add(int x, int y) {
		//보조기능 장착
		long start = System.nanoTime();
		int result  = x+y; //핵심관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("덧셈처리시간%d ns\n",(end-start));
		return result;
	}

	@Override
	public int sub(int x, int y) {
		long start = System.nanoTime();
		int result  = x-y; //핵심관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("덧셈처리시간%d ns\n",(end-start));
		return result;
	}

	@Override
	public int mult(int x, int y) {
		long start = System.nanoTime();
		int result  = x*y; //핵심관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("덧셈처리시간%d ns\n",(end-start));

		return result;
	}

	@Override
	public int div(int x, int y) {
		long start = System.nanoTime();
		int result  = x/y; //핵심관심 사항(core concern)
		long end = System.nanoTime();
		System.out.printf("덧셈처리시간%d ns\n",(end-start));
		return result;
	}

}
