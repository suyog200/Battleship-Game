package player;




import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
	 public static Position readPosition(Scanner sc, Board board, String message){
	        try {
	            System.out.print(message);
	            String s = sc.nextLine().toLowerCase();
	            char row = s.charAt(0);
	            int column = Integer.parseInt(s.substring(1));
	            Position.isInRange(row, column, board);
	            return new Position(row, column - 1);
	        } catch (PositionException | NumberFormatException | StringIndexOutOfBoundsException e){
	            Display.printError("Errore, valori consentiti tra a1 e " + Position.encode(board.getLength() - 1) + board.getLength());
	            return readPosition(sc, board, message);
	        }

	    }

}
