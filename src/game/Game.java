package game;

import board.Board;
import player.IPlayer;
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
		// more to add here
	}
	private void choosePlacement()
	{
		String placementType = input.getString("Please choose: m for manual or r for random ship placement:").toLowerCase();
		switch(placementType)
		{
		case "m" -> manualGameplay(); //this method will be called
		case "t" -> {
			testGameplay(board1,board2);
			istest = true;
		}
		default -> randomGameplay();
		}
	}

}
