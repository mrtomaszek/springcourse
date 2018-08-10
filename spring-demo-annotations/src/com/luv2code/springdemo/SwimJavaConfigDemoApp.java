package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		SwimCoach secondCoach = context.getBean("swimCoach", SwimCoach.class);

		System.out.println(secondCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyFortune());

		System.out.println("email: " + secondCoach.getEmail());
		System.out.println("email: " + secondCoach.getTeam());
		
		
		
		context.close();

	}

}
