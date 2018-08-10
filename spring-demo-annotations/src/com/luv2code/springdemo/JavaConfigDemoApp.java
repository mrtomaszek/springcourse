package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		Coach secondCoach = context.getBean("tennisCoach", Coach.class);

		System.out.println(secondCoach.getDailyWorkout());
		System.out.println(secondCoach.getDailyFortune());

		context.close();

	}

}
