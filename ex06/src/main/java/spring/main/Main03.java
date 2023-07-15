package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main03 {
	public static void main(String[] args) {
		// XML 스키마 기반 자바 POJO 클래스를 이용한 방법
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx01.xml");
		
		Calculator impeCalc = ctx.getBean("impeCalc", Calculator.class);
		System.out.println("impeCalc.factorial(10) 결과 : " + impeCalc.factorial(10));
	}
}