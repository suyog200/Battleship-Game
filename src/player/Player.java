package player;
import board.Board;
import ships.Ship;
import java.util.Arraylist;
public class Player extends IPlayer{
	
	public Player(String name, Board board, int rank, String symbol) {
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
	public Boolean IsAlive()
	{
		for (Ship ship: this.ships) {
			if(!ship.isSunk()) return true;
		}
		return false;
	}
}
