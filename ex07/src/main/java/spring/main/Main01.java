package spring.main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberListPrinter;
import spring.service.ChangePasswordService;
import spring.service.MemberRegisterService;
import spring.vo.RegisterRequest;

public class Main01 {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx01.xml");
		
		// Insert 기능 테스트
		MemberRegisterService regSvc = ctx.getBean("regSvc", MemberRegisterService.class);
		insert(regSvc);
		System.out.println("가입 완료");
		
		// Update 기능 테스트
		MemberDao dao = ctx.getBean("memberDao", MemberDao.class);
		ChangePasswordService changeSvc = ctx.getBean("changeSvc", ChangePasswordService.class);
		update(changeSvc, dao);
		System.out.println("변경 완료");
		
		// 전체 데이터 출력
		MemberListPrinter listPrt = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrt.printAll();
		
		// 특정 데이터 출력
		MemberInfoPrinter infoPrt = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrt.printMemberInfo("park@naver.com");
	}

	private static void update(ChangePasswordService changeSvc, MemberDao dao) {
		String email = "park@naver.com";
		
		String oldPassword = dao.selectByEmail(email).getPassword();
		String newPassword = "";
		
		if(oldPassword.equals("1234")) {
			newPassword = "4321";
		}else if(oldPassword.equals("4321")) {
			newPassword = "1234";
		}
		
		changeSvc.changePassword(email, oldPassword, newPassword);
	}

	private static void insert(MemberRegisterService regSvc) {
		// 매번 실행할 때마다 중복없이 데이터 입력하도록 테스트 코드 작성
		RegisterRequest rr = new RegisterRequest();
		
		SimpleDateFormat dateFormate = new SimpleDateFormat("YYYYMMdd-HHmmss");
		String str = dateFormate.format(new Date());
		rr.setName(str);
		rr.setEmail(str + "@naver.com");
		rr.setPassword("1234");
		rr.setConfirmPassword("1234");
		
		regSvc.regist(rr);
	}
}