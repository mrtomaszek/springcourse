package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OldCoachDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OldCoachConfig.class);

		Coach myCoach = context.getBean("oldCoach", Coach.class);
		
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		
		context.close();
	}

}
