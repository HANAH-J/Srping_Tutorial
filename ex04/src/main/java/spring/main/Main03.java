package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.config.ConfigPartMain;
import spring.printer.MemberInfoPrinter;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main03 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigPartMain.class);

		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);

		MemberInfoPrinter info = ctx.getBean("infoPrinter", MemberInfoPrinter.class);

		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("hong@naver.com"); // request.getParameter("name");
		regReq.setName("홍길동");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");

		regSvc.regist(regReq); // 회원 가입

		info.printMemberInfo("hong@naver.com"); // 이메일 정보를 통해서 회원 정보 출력
	}
}