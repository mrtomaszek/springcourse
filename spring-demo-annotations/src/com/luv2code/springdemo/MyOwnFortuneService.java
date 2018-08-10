package com.luv2code.springdemo;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyOwnFortuneService implements FortuneService {
	
	
	private String [] data;
	@Value("${a}")
	private String a;
	@Value("${b}")
	private String b;
	@Value("${c}")
	private String c;
	@Value("${d}")
	private String d;
	@Value("${e}")
	private String e;
	
	@PostConstruct
	public void setupMyData() {
		data = new String[5];
		
		data[0] = a;
        data[1] = b;
        data[2] = c;
        data[3] = d;
        data[4] = e;
	}
	
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String result = data[index];
		return result;
	
	}

}
