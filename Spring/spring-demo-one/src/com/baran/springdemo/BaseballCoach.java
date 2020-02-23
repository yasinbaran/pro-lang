package com.baran.springdemo;

public class BaseballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define a contructor for dependency injeciton
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkOut() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {

		// use my fortuneService to get fortune
		return fortuneService.getFortune();
	}

}
