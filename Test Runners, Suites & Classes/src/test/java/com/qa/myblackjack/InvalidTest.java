package com.qa.myblackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InvalidTest {
	Blackjack b = new Blackjack();
	@Test
	public void test1() {	
		assertEquals("2 invalid entries",0,b.play(-10,-10));
	}
	@Test
	public void test2() {
		assertEquals("1 invalid entry",0,b.play(-10,10));
	}
	@Test
	public void test3() {
		assertEquals("2 invalid entries",0,b.play(-10,30));
	}
	@Test
	public void test4() {
		assertEquals("2 invalid entries",0,b.play(-10,50));
	}
	@Test
	public void test5() { 
		assertEquals("1 low invalid entry",0,b.play(10,0));
	}
	@Test
	public void test9() {
		assertEquals("1 invalid entry", 0,b.play(10,32));
	}
	@Test
	public void test10() {
		assertEquals("1 invalid entry",0,b.play(30,-10));
	}
	@Test
	public void test13() {
		assertEquals("1 invalid entry",0,b.play(30,50));
	}
	@Test
	public void test14() {
		assertEquals("2 invalid entries",0,b.play(50,-10));
	}
	@Test
	public void test15() {
		assertEquals("1 invalid entry",0,b.play(50,10));
	}
	@Test
	public void test16() {
		assertEquals("1 invalid entry",0,b.play(50,30));
	}
	@Test
	public void test17() {
		assertEquals("two invalid entries",0,b.play(50,50));
	}	
}
