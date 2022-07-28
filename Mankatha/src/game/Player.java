package game;

public class Player {

	private String name;
	private int coins;
	private String chosenCard;
	private String chosenOrientation;
	private int winnings = 0;
	private int bet;
	
	public Player(String name, int coins, String chosenCard, String chosenOrientation) {
		super();
		this.name = name;
		this.coins = coins;
		this.chosenCard = chosenCard;
		this.chosenOrientation = chosenOrientation;
	}
	
	public Player() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public String getChosenCard() {
		return chosenCard;
	}

	public void setChosenCard(String chosenCard) {
		this.chosenCard = chosenCard;
	}

	public String getChosenOrientation() {
		return chosenOrientation;
	}

	public void setChosenOrientation(String chosenOrientation) {
		this.chosenOrientation = chosenOrientation;
	}

	public int bet(int betCoins)
	{
	      this.coins -= betCoins;
	      return coins;
	      
	}
	
	public void addWinnings(int coins) 
	{
		this.coins += coins;
		
	}
	
}
