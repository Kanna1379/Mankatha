package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private List<Player> players;
	private Player host;
	public Game(List<Player> players) {
		
		this.players = players;
		int rand = new Random().nextInt(0,players.size());
		Player host = players.get(rand);
		Deck deck = new Deck();
		deck.shuffle();
	}
	
	public Player findWinner(Card currentCard, String currentOrientation) {	
		Player winner = null;
		for(Player p: players) 
		{
			if(p.equals(host)) 
				continue;
			if((p.getChosenCard().equals(currentCard) && p.getChosenOrientation() ==  currentOrientation) && p.bet(0)==0) 
			{
				winner = p;
			}
		}
		return winner;
		
		
	}
	public Player findLoser(Card currentCard, String currentOrientation) 
	{
	Player loser = null;
	for(Player p: players) 
	{
		if(p.equals(host)) 
			continue;
		if(( p.getChosenCard().equals(currentCard) && p.getChosenOrientation() !=  currentOrientation) || p.bet(0)==0) 
		{
			loser = p;
		}
	}
	return loser;
	}
	
	public void takeBets() {
		Scanner sc = new Scanner(System.in);
		System.out.println(host.getName());
		for(Player p: players) {
			System.out.println(p.getName() + "turn");
			System.out.println("Enter bet");
			int currentBet = sc.nextInt();
			while(p.bet(currentBet)<0)
			{
				if(p.getCoins()==0) 
				{
					System.out.println("Insufficient coins"+p.getName()+"can't play");
					players.remove(p);
					break;
				}
			}
		}
	}
	
	public Player play(List<Player> players) {
			Deck deck = new Deck();
			String currentOrientation = "in";
			Player roundWinner = null;
			List<Player> winnerCandidates = players;
			takeBets();
			while(deck.cardsLeft() > 0 && roundWinner == null && winnerCandidates.size() > 1) {
				Card currentCard = deck.deal();
				System.out.println(currentCard+" "+currentOrientation);
				roundWinner = findWinner(currentCard,currentOrientation);
				Player turnLoser = findLoser(currentCard,currentOrientation);
				if(roundWinner != null) System.out.println("Winner found");
				else if(turnLoser != null) System.out.println(turnLoser.getName()+"has lost their bet");
				else System.out.println("Winner not found");
				currentOrientation = currentOrientation.equals("in") ? "out" : "in";
				
			}
			if(roundWinner == null) roundWinner = host;
			int winnings = 0;
			for(Player p: players) {
				winnings += p.bet(p.getCoins());
			}	
			roundWinner.addWinnings(winnings);
			host = roundWinner;
			System.out.println("Winner and new host "+ roundWinner.getName());
			
			
			return roundWinner;
		}
			
		}

