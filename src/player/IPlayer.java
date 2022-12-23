package player;
import board.Board;
import ships.Ship;
import java.util.ArrayList;



public abstract class IPlayer {
	protected Board board;
	public String name;
	public ArrayList<Ship> ships= new ArrayList<>();
	
	public Integer rank;
	public String symbol;
	public ArrayList<Integer[]> struck =new ArrayList<>();   
	
	public void handleShot(Integer[] shot,IPlayer opponent) {
		
	}
	public Boolean isAlive() {
		return true;
	}
	public Boolean validshot(Integer[] shot, IPlayer opponent) 
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

