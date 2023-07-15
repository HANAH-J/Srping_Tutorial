package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.aspect.ExeTimeAspect2;
import spring.calc.Calculator;
import spring.calc.ImpeCalculator;
import spring.calc.RecCalculator;

@Configuration
@EnableAspectJAutoProxy // <aop:aspectj-autoproxy/>
public class JavaConfig {
	// 대상 객체를 빈으로 등록
	@Bean
	public Calculator impeCalc() {
		return new ImpeCalculator();
	}
	
	@Bean
	public Calculator recCalc() {
		return new RecCalculator();
	}
	
	// 프록시(공통 기능) 객체도 빈으로 등록
	@Bean
	public ExeTimeAspect2 exeTimeAspect() {
		return new ExeTimeAspect2();
	}
}