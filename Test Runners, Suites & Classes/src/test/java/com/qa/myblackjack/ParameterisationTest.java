package com.qa.myblackjack;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterisationTest { 
	Blackjack game = new Blackjack();
	
@Parameters
public static Collection<Object[]> data(){
	return Arrays.asList(new Object[][] {{0,-10,10},{12,10,12},{0,50,50}});
}

private int intPlayer; 
private int intDealer;
private int intPected;

//Overloading constructor
public ParameterisationTest( int expected,int player,int dealer) {
	intPected = expected; intPlayer = player; intDealer = dealer; 
}

@Test
public void test() {
	assertEquals(intPected, game.play(intPlayer,intDealer));	
	}
}
