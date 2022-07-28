package game;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String args[]) {
		List<Card> cards = new ArrayList<>();
		
		Player p1 = new Player("Arun",100,"two of diamonds","in");
		Player p2 = new Player("John",200,"five of spades","out");
		Player p3 = new Player("Aruna",150,"ace of clubs","in");
		Player p4 = new Player("James",100,"seven of hearts","out");
		
		List<Player> players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		Game g = new Game(players);
		
	}
}
