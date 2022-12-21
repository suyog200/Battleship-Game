package player;
import java.util.ArrayList;

import board.Board;
import ships.Ship;

public abstract class IPlayer {
	protected Board board;
	public String name;
	public ArrayList<Ship> ships= new ArrayList<>();
	
	public Integer rank;
	public String symbol;
	public ArrayList<int[]> struck =new ArrayList<>();   
	
	public void handleShot(int[] shot,IPlayer opponent) {
		
	}
	public boolean isAlive() {
		return true;
	}
	public boolean validshot(int[] shot, IPlayer opponent) 
	   {
		try {
			opponent.getBoard().getOcean()[shot[0]][shot[1]].setHit();
		}catch (IndexOutOfBoundsException e) {
            return false;
        } return true;
        }
	public Board getBoard() {
        return board;
    }

    public void addShip(Ship ship) {
        this.ships.add(ship);
    }
	}

