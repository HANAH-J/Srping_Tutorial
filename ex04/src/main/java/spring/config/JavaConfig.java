package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.dao.MemberDao;
import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;
import spring.service.MemberRegisterService;

@Configuration
public class JavaConfig { // 스프링 빈 설정 파일
	
//	<bean id="memberDao" class="spring.dao.MemberDao"></bean>
//	public spring.dao.MemberDao memberDao() {
//		return new spring.dao.MemberDao();
//	}
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
										 // 생성자 주입
	}
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		// Setter 메서드 주입
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		
//		infoPrinter.setMemberDao(memberDao());
//		infoPrinter.setPrinter(printer());
		
		return infoPrinter;
	}
}