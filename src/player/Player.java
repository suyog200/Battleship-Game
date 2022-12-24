package player;
import board.Board;

import ships.Ship;

public class Player extends IPlayer{

	public Player(String name, Board board,Integer rank, String symbol) {

		this.name = name;
		this.board =board;
		this.rank= rank;
		this.symbol= symbol;
	}
	public Player(String name)
	{
		this.name= name;
	}
	public Player(Board board)
	{
		this.board= board;
	}
	public Player()
	{
		
	}
	public Boolean isAlive()
	{
		for (Ship ship: this.ships) {
			if(!ship.isSunk()) return true;
		}
		return false;
	}
	  @Override
	    public void handleShot(Integer[] shot, IPlayer opponent) {
	        this.struck.add(shot);
	        opponent.getBoard().getOcean()[shot[0]][shot[1]].setVisibility(false);
	        opponent.getBoard().getOcean()[shot[0]][shot[1]].setHit();
	        for (Ship ship: opponent.ships) {
	            ship.canShipSink();
	        }
	    }
}
