package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main03 {
	// 스프링은 별도의 설정이 없는 경우 한 개의 빈 객체만 생성 => 싱글톤
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:app.xml");
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}