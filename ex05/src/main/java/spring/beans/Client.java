package spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client implements InitializingBean, DisposableBean {
	private String host;
	
	public Client() {
		System.out.println("빈 생성 : Client() 실행");
	}

	public void setHost(String host) { // 문자열 객체를 주입 받는다.
		this.host = host;
		System.out.println("빈 의존 주입 : Client.setHost() 실행");
	}
	
	public void send() { // 실제 사용할 메서드
		System.out.println("빈 동작 : Client.send() 실행 : " + host);
	}

	@Override
	public void destroy() throws Exception {
		// 빈 소멸 시 작동할 메서드
		System.out.println("빈 소멸 : Client.destroy() 실행");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// 빈 초기화 시 작동할 메서드
		System.out.println("빈 초기화 : Client.afterPropertiesSet() 실행");
	}
}