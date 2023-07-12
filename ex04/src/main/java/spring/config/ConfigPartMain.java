package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
@Import(ConfigPartSub.class)// 다른 Java 설정 파일을 가져와서 합치는 방법
// @Import({ConfigPart01.class, ConfigPart02.class, ConfigPart03.class...})
public class ConfigPartMain {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
										 // 생성자 주입
	}
}