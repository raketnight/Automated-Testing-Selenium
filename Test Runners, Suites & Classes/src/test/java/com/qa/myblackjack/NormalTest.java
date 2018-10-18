package com.qa.myblackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NormalTest {
	Blackjack b = new Blackjack();
	@Test
	public void test6() {
		assertEquals("2 valid entries", 12,b.play(10,12)); 
	}
	@Test
	public void test8() {
		assertEquals("2 valid entries",12,b.play(12,10));
	}

}
