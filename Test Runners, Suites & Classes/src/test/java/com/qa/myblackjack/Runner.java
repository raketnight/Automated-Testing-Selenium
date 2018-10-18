package com.qa.myblackjack;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runner {
	public static void main(String[] args) {
		Runner.allTests();
	}
	
	public static void allTests() {
		Result result = JUnitCore.runClasses(InvalidSuite.class,ValidSuite.class);
		
		System.out.println("All results passed: "+ result.wasSuccessful());
		
		if(!result.wasSuccessful()) {
			System.out.println("Failed tests:");
			for(Failure failure: result.getFailures()) {
				System.out.println(failure.getMessage());
			}
		}
	}

}
