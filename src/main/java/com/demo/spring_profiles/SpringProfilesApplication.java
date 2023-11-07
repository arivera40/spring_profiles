package com.demo.spring_profiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringProfilesApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringProfilesApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
	
	@Profile("dev")
	@Bean
	public String devBean() {
		return "dev";
	}
	
	@Profile("qa")
	@Bean
	public String qaBean() {
		return "qa";
	}
	
	@Profile("prod")
	@Bean
	public String prodBean() {
		return "prod";
	}

}
