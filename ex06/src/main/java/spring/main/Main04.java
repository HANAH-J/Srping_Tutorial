package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.calc.Calculator;

public class Main04 {
	public static void main(String[] args) {
		// @Aspect 어노테이션을 이용해서 Aspect 설정 사용
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx02.xml");

		Calculator impeCalc = ctx.getBean("impeCalc", Calculator.class);
		System.out.println("impeCalc.factorial(10) 결과 : " + impeCalc.factorial(10));
	}
}