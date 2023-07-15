package spring.main;

import spring.aspect.ExeTimeCalculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

public class Main02 {
	public static void main(String[] args) {
		// 프록시 객체(ExeTimeCalculator)를 활용한 공통 기능과 핵심 기능의 분리
		
		ExeTimeCalculator impeCal = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println("impeCal의 결과값 : " + impeCal.factorial(5));
		
		ExeTimeCalculator recCal = new ExeTimeCalculator(new RecCalculator());
		System.out.println("recCal의 결과값 : " + recCal.factorial(5));
	}
}