package com.qa.myblackjack;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlackjackTest {
	Blackjack b = new Blackjack();
	static int counter = 1;
	
	@BeforeClass
	public static void start() {
		System.out.println("Welcome to the tests\n");
	}
	
	@Before
	public void setUp() {
		System.out.println("Running test "+ counter +"/17");
	}
	
	@After
	public void tearDown() {
		System.out.println("Test "+ counter +"/17 has finished\n");
		counter++;
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("Testing is now complete");
	}
	
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
	public void test6() {
		assertEquals("2 valid entries", 12,b.play(10,12));
	}
	@Test
	public void test7() {
		assertEquals("2 valid entries",10,b.play(10,22));
	}
	@Test
	public void test8() {
		assertEquals("2 valid entries",12,b.play(12,10));
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
	public void test11() { 
		assertEquals("2 valid entries",10,b.play(30,10));
	}
	@Test
	public void test12() {
		assertEquals("2 valid entries",0,b.play(30,30));
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
