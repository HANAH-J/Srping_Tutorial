package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.calc.Calculator;
import spring.config.JavaConfig;

public class Main05 {
	public static void main(String[] args) {
		// 자바 설정을 이용한 Aspect 적용
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);

		Calculator impeCalc = ctx.getBean("impeCalc", Calculator.class);
		System.out.println("impeCalc.factorial(10) 결과 : " + impeCalc.factorial(10));
	}
}