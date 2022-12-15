package board;

public class Board {
	public final int BOARD_SIZE = 10;

    private final Square[][] ocean = new Square[BOARD_SIZE][BOARD_SIZE];
    
    
    public Square[][] getOcean() {
        return ocean;
    }
}
