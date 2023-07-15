package spring.calc;

public class ImpeCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		// 팩토리얼 계산법 : 재귀 없이 팩토리얼 구하기
		
		// long start = System.currentTimeMillis();
		
		long result = 1;
		for(long i=1; i<=num; i++) {
			result *= i;
		}
		
		// long end = System.currentTimeMillis();
		
		// System.out.printf("impeCalculator.factorial(%d)의 실행 시간 : %d\n", num, (end - start));
		return result;
	}

}