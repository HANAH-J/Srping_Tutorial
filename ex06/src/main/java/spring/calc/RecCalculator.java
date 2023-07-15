package spring.calc;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		// 팩토리얼 계산법 : 재귀 없이 팩토리얼 구하기
		
		// long start = System.currentTimeMillis();
		
//		try {
			if(num == 0) {
				return 1;
			}else {
				return num * factorial(num-1);
			}
//		}finally {
//			long end = System.currentTimeMillis();
//			System.out.printf("RecCalculator.factorial(%d)의 실행 시간 : %d\n", num, (end - start));
//		}
		
	}

}