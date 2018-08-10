package com.luv2code.springdemo;

public class OldCoach implements Coach {

	private FortuneService fortune;
	
	
	
	public OldCoach(FortuneService fortune) {
		this.fortune = fortune;
	}

	@Override
	public String getDailyWorkout() {
		return "just enjoy your training";
	}

	@Override
	public String getDailyFortune() {
		return fortune.getFortune();
	}

}
