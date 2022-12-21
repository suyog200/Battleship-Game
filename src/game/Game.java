package game;

import board.Board;
import board.BoardFactory;
import player.IPlayer;
import player.Player;
import ships.ShipType;
import utilities.Display;
import utilities.Input;

public class Game {
	Display display = new Display(); // created objects of classes.
	Board board1 = new Board();
	Board board2 = new Board();
	Input input = new Input();
	BoardFactory bf = new BoardFactory();
	IPlayer player; //class Iplayer reference
	IPlayer opponent; //class Iplayer reference
	boolean isTest = false;
	
	public void mainGame()
	{
		player = new Player(input.getString("Player 1, what is your name? "),board1,1,"🟥");
		opponent = new Player(input.getString("Player 2, what is your name? "),board2,2,"🟦");
		choosePlacement(); // to choose how to place ships
		setBoardVisibility(board1,board2); // visibility of board
		Display.printTwoBoards(board1,board2,isTest); // calling method from Display class to print two boards
		
		while(player.isAlive() && opponent.isAlive()) {
			shootingPhase(player,opponent,board1,board2);
		}
		victory(player,opponent);
	}
	
	private void choosePlacement()
	{
		String placementType = input.getString("Please choose: m for manual or r for random ship placement:").toLowerCase();
		switch(placementType)
		{
		case "m" -> manualGameplay(); //this method will be called
		case "t" -> {
			testGameplay(board1,board2);
			isTest = true;
		}
		default -> randomGameplay();
		}
	}
	
	private void setBoardVisibility(Board board1, Board board2)// makes board for both player visible
	{
		board1.setBoardVisibility(true);
		board2.setBoardVisibility(true);
	}
	
	private void swapPlayer(IPlayer player, IPlayer opponent)
	{
		if(this.player == player)
		{
			this.player = opponent;
			this.opponent = player;
		}
		else
		{
			this.player = player;
			this.opponent = opponent;
		}
	}
	private void playVsAi(int mode) {
		// to be added
	}
	private void waitingForAI() {
		display.shout("Calculating...");
		Display.wait(1000);
	}
	private void victory(IPlayer player, IPlayer opponent) // displays which player has won
	{
		String victoryShout;
		if(player.isAlive()) {
			victoryShout = player.name+" has won!";
		}
		else {
			victoryShout = opponent.name+ "has won!";
		}
		display.shout(victoryShout); // calls method shout from Display class
	}
	
	private void randomGameplay() {
		Display.printSingleBoard(board1);
		for(int j=0;j<2;j++) {
			for(int i=5;i>1;i++) {
				if(j == 0) {
					bf.randomPlacement((Player) player, ShipType.values()[i-1]);
					Display.printSingleBoard(board1);
				}else {
					bf.randomPlacement(opponent, ShipType.values()[i-1]);
				}
			}
		}
	}
	private void randomVsAiGameplay() {
		// to be added 
	}
	private void manualGameplay() {  // both player and opponent have to place their ships manually
		var listOfShips = new ShipType[] { // list of ships
				ShipType.Carrier,
				ShipType.Cruiser,
				ShipType.Battleship,
				ShipType.Destroyer,
		};
		for(int j=0;j<2;j++) {
			for(var ship: listOfShips) {
				Display.clear();
				if(j==0) {
					Display.printSingleBoard(board1); //prints board by calling that method define in class Display
					bf.manualPlacement((Player) player,ship);
					Display.printSingleBoard(board1);
				}else {
					Display.printSingleBoard(board2);
					bf.manualPlacement((Player) opponent, ship);
					Display.printSingleBoard(board2);
				}
				if(ship.getLength() == 2) {
					Display.clear();
				}
			}
		}
	}
	private void AivsAiPlacement() {
		// to be added
	}
	private void testGameplay(Board board1, Board board2) {
		Display.printSingleBoard(board1);
		bf.randomPlacement(player, ShipType.values()[4]);
		bf.randomPlacement(opponent, ShipType.values()[4]);
		bf.randomPlacement(player, ShipType.values()[4]);
		bf.randomPlacement(opponent, ShipType.values()[4]);
		Display.printSingleBoard(board1);
		Display.printSingleBoard(board2);
	}
	
	private void shootingPhase() {
		// to be added 
	}
	
	private void mainMenu() { //main menu which will be displayed at start
		int mode = input.getInt("Welcome! What game mode do you prefer? \n1: Pilot vs Pilot\n2: Top Gun\n3: Terminator II");
		while(mode < 1 || mode > 3) {
			mode = input.getInt("Pick between 1 and 3\n");
		}
		switch(mode) {
		case 1-> mainGame();
		case 2-> playVsAi(2);
		case 3-> aiVsAi();
		}
	}
	

	
	
	
	
	
	
}
