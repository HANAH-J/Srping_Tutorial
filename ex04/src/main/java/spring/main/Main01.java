package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.JavaConfig;
import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {
	public static void main(String[] args) {
		// 1. 스프링 빈 설정 파일을 읽어서 스프링 컨테이너를 생성
		// AnnotationConfigApplicationContext ctx =
		ApplicationContext ctx =
				new AnnotationConfigApplicationContext(JavaConfig.class);

		// 2. 컨테이너에 있는 사용할 빈을 가져오도록 합니다.
		// -> 자동 주입 처리가 된 빈
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);

		MemberInfoPrinter info = ctx.getBean("infoPrinter", MemberInfoPrinter.class);

		// 3. 자동 주입이 잘 되었는지 체크
		// 회원 가입 처리 후 회원 정보 출력
		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com"); // request.getParameter("name");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");

		regSvc.regist(regReq); // 회원 가입

		info.printMemberInfo("hong@naver.com"); // 이메일 정보를 통해서 회원 정보 출력
	}
}