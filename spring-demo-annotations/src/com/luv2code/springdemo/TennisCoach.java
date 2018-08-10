package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	private FortuneService fortuneService;

	// @Autowired
	// public TennisCoach(FortuneService fortuneService) {
	// this.fortuneService = fortuneService;
	// }

	public TennisCoach() {

	}
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TennisCoach: inside the doMyStartupStaff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside the doMyCleanupStuff");
	}
	

	/*@Autowired
	public void hiFive(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
