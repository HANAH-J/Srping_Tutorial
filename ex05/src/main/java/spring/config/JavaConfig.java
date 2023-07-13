package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.beans.Client;
import spring.beans.Client2;

@Configuration
public class JavaConfig {
	@Bean
	public Client client() {
		Client client = new Client();
//		client.setHost("웹서버");
		return client;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client2 = new Client2();
		client2.setHost("웹서버");
		return client2;
	}
}