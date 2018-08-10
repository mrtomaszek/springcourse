package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OldCoachConfig {

	@Bean
	public FortuneService lastFortuneService() {
		return new LastFortuneService();
	}
	
	@Bean
	public Coach oldCoach() {
		return new OldCoach(lastFortuneService());
	}
	
	
}
