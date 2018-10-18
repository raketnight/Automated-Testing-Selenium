package com.qa.myblackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BustTest {
	Blackjack b = new Blackjack();
	@Test
	public void test7() {
		assertEquals("2 valid entries",10,b.play(10,22));
	}
	@Test
	public void test11() {
		assertEquals("2 valid entries",10,b.play(30,10)); 
	}
	@Test
	public void test12() {
		assertEquals("2 valid entries",0,b.play(30,30));
	}
	
}
