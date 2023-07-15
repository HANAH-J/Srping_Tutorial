package spring.main;

import spring.calc.RecCalculator;
import spring.calc.ImpeCalculator;

public class Main01 {
	public static void main(String[] args) {
		ImpeCalculator impe = new ImpeCalculator();
		long fiveFacImpe = impe.factorial(5);
		
		RecCalculator rec = new RecCalculator();
		long fiveFacRec = rec.factorial(5);
		
		// 핵심 기능 : 팩토리얼을 구하는 기능
		// 공통 기능 : 팩토리얼을 구하는 데 걸리는 시간을 측정하는 기능
		
		// AOP 비즈니스 로직을 핵심 기능과 공통 기능으로 분리해서
		// 개발자에게 핵심 기능에만 몰입할 수 있도록 도와주는 프로그래밍 기법
		
		System.out.println("fiveFacImpe의 결과값 : " + fiveFacImpe);
		System.out.println("fiveFacRec의 결과값 : " + fiveFacRec);
	}
}