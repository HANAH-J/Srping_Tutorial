package ex01;

public class Main01 {
	public static void main(String[] args) {
		// 자바에서 메서드를 사용하는 방법
		// 인스턴스를 만들어서 사용
		
		// 인사말 출력
		Greeter gt = new Greeter();
		gt.setFormat("%s님 안녕하세요");
		String message = gt.greet("홍길동");
		
		System.out.println(message);
	}
}
