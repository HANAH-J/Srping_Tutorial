package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.beans.Client2;
import spring.config.JavaConfig;

public class Main02 {
	public static void main(String[] args) {
		useXml();
		System.out.println("==================================================");
		useJava();
	}

	private static void useJava() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		Client2 c = ctx.getBean("client2", Client2.class);
		
		c.send();
		
		ctx.close();
	}

	private static void useXml() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
		
		Client2 c = ctx.getBean("client2", Client2.class);
		
		c.send();
		
		ctx.close();
	}
}