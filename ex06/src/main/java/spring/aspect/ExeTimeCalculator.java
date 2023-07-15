package spring.aspect;

import spring.calc.Calculator;

public class ExeTimeCalculator implements Calculator {
	// 프록시 객체
	// -> 핵심 기능을 수행하기 위해서 거쳐가는 클래스
	private Calculator calc; // 핵심 기능을 가진 클래스

	public ExeTimeCalculator(Calculator calc) {
		this.calc = calc;
	}

	@Override
	public long factorial(long num) { // 공통 기능을 만들기 위한 메서드
		// 핵심 기능을 수행하기 전 공통 기능
		// long start = System.currentTimeMillis();
		long start = System.nanoTime();
		
		// 핵심 기능
		long result = calc.factorial(num);
		
		// 핵심 기능을 수행하고 난 후 공통 기능
		// long end = System.currentTimeMillis();
		long end = System.nanoTime();
		
		System.out.printf("%s.factorial(%d)의 실행 시간 : %d\n", 
				calc.getClass().getSimpleName(), num, (end - start));
		
		return result;
	}
	
}