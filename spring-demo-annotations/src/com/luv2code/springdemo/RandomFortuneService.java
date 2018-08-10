package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] data = {
			"Hi doggie",
			"Oh hi Mark",
			"I did not hit her, i did not",
			"You're tearing me apart!!"
	};
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {		
		int index = myRandom.nextInt(data.length);
		String fortune = data[index];
		return fortune;
	}

}
