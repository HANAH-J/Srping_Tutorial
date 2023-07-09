package ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main02 {
	public static void main(String[] args) {
		// 스프링에서 객체를 사용하는 방법
		// 스프링 컨테이너 객체를 미리 만들어 둔다.
		// 개발자가 필요하면 꺼내서 사용할 수 있다. => IoC : 제어의 역전
		
		// 1. 스프링이 가진 빈의 정보를 가진 파일이 어디있나?
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:app.xml");
		// 스프링 설정파일을 읽어서 빈 객체를 등록하세요.
		
		// 2. 스프링 컨테이너에서 생성된 빈을 가져온다.
		Greeter gt = ctx.getBean("greeter", Greeter.class);
		
		// 3. 가져온 객체를 사용하면 된다.
		String msg = gt.greet("고길동");
		
		System.out.println(msg);
	}
}