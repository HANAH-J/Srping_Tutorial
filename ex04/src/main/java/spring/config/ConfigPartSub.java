package spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.printer.MemberInfoPrinter;
import spring.printer.MemberPrinter;

@Configuration
public class ConfigPartSub {
	@Autowired
	private ConfigPartMain configPartMain;
	
	@Bean
	public MemberPrinter printer() {
		return new MemberPrinter();
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		// Setter 메서드 주입
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		
		infoPrinter.setMemberDao(configPartMain.memberDao());
//		infoPrinter.setPrinter(printer());
		
		return infoPrinter;
	}
}