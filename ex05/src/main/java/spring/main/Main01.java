package spring.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.beans.Client;

public class Main01 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		// 스프링 빈 설정 파일을 읽어온다.
		// => 스프링 컨테이너 초기화
		//				  빈 객체 생성 -> 빈 객체 간 의존 주입 -> 빈 객체 초기화
		//												   afterPropertiesSet()
		
		Client client = ctx.getBean("client", Client.class);
		
		client.send(); // 빈 사용
		
		// 컨테이너를 종료 => 컨테이너 내부의 빈 객체는 소멸
		ctx.close();						  // destroy()
	}
}