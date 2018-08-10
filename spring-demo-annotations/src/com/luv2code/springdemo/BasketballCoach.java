package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice 3 point throws for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
