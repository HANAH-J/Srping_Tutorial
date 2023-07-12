package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import spring.dao.MemberDao;
import spring.service.MemberRegisterService;

@Configuration
@ImportResource("classpath:configSub.xml") // xml 설정을 가져와서 Java 설정에 합친다.
public class JavaMainConfig {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}
}