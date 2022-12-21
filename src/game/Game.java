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

	
	
	
	
	
	
}
