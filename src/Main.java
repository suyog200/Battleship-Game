import game.Game;
import utilities.Display;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display display = new Display();
		
		display.displayMainMenu();
		Game game = new Game();
		game.mainMenu();

	}

}
