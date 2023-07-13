package spring.beans;

public class Client2 {
	private String host;
	
	public void setHost(String host) { // 문자열 객체를 주입 받는다.
		this.host = host;
		System.out.println("빈 의존 주입 : Client2.setHost() 실행");
	}
	
	public void send() { // 실제 사용할 메서드
		System.out.println("빈 동작 : Client2.send() 실행 : " + host);
	}

	public void close() throws Exception {
		// 빈 소멸 시 작동할 메서드
		System.out.println("빈 소멸 : Client2.close() 실행");
	}

	public void connect() throws Exception {
		// 빈 초기화 시 작동할 메서드
		System.out.println("빈 초기화 : Client2.connect() 실행");
	}
}