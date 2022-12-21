package ships;

import board.Square;


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
    
  //method to check if the ship can sink when hit
    public void canShipSink() {
        boolean shouldBeSunk = true;
        for (Square nextSquare : squares) {
            if (!nextSquare.isHit()) shouldBeSunk = false;
        }
        if (shouldBeSunk && !this.isSunk) setSunk();
    }
  
}
