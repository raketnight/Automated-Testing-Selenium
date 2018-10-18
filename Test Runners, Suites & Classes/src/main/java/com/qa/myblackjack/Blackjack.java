package com.qa.myblackjack;

public class Blackjack {
	 
	public int play(int player, int dealer) {
		
		if(player > 31 || dealer > 31 || player <= 0 || dealer <= 0) {
			return 0;
		}
		else if(player > 21 && dealer > 21) {
			return 0;
		}
		else if((player <= 21 && player > 0) && (dealer > 21)) {
			return player;
		}
		else if(player > 21 && (dealer <= 21 && dealer > 0)) {
			return dealer;
		}
		else {
			boolean playerWins = Math.abs(21 - player) < Math.abs(21 - dealer);
			if(playerWins) {
				return player;
			}
			
			else {
				return dealer; 
			}
		}	
	}

}
