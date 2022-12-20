package ships;

import java.util.List;

import board.Square;

public class Ship {

    private List<Square> squares;
    private boolean isSunk;
    private ShipType shipType;
    Display display = new Display();


    public Ship(ArrayList<Square> squares, ShipType shipType) {
        this.squares = squares;
        this.isSunk = false;
        this.shipType = shipType;
    }
}
