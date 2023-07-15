package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main06 {
	public static void main(String[] args) {
		// Aspect의 우선순위
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx03.xml");

		Calculator impeCalc = ctx.getBean("impeCalc", Calculator.class);
		impeCalc.factorial(10); // 캐시가 없을 때 -> 캐시 등록
		impeCalc.factorial(10); // 캐시가 있을 때
	}
}