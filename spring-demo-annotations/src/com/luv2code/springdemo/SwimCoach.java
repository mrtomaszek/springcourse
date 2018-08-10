package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortune;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach(FortuneService fortune) {
		this.fortune = fortune;
	}
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}
	public String getEmail() {
		return email;
	}
	public String getTeam() {
		return team;
	}

	
	
}
