package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortune implements FortuneService {
	
	private String[] fortune = {
			"you're lucky mate",
			"not really your day",
			"well, it could be worse"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortune.length);
		
		String yourFortune = fortune[index];
		return yourFortune;
	}

}
