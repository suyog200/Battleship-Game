package ships;

import java.util.List;

import board.Square;
import utilities.Display;

public class Ship {

    private List<Square> squares;
    private boolean isSunk;
    private ShipType shipType;
    Display display = new Display();

//getters and setters for ship
    public Ship(ArrayList<Square> squares, ShipType shipType) {
        this.squares = squares;
        this.isSunk = false;
        this.shipType = shipType;
    }
    
    //method to define that the player has sunk a ship 
    public void setSunk() {
        for (Square square : this.squares) {
            square.setSunk();
        }
        display.shout("You've sunk a ship!");
        this.isSunk = true; 
        Display.wait(1500);
    } 

    public boolean isSunk() {
        return this.isSunk;
    }

}
