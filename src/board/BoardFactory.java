package board;

import utilities.Display;
import utilities.Input;

public class BoardFactory {
    Input input = new Input();
    Display display = new Display();
	
    public String isInputHorizontalOrVertical() {
        boolean isOk = false;
        String string;
        do {
            string = input.getString("Horizontal or vertical? ");
            String letter = string.toLowerCase();
            switch (letter) {
                case "h", "v" -> isOk = true;
                default -> string = input.getString("Only h or v please!");
            }
        } while (!isOk);
        return string;
    }
}
