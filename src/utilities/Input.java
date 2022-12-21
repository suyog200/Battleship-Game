package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
      
	private final Scanner input = new Scanner(System.in);
    private final Display display = new Display();
	
  //get input string
	public String getString(String message) {
		Scanner sc = new Scanner(System.in); 
        display.shout(message);

        String text = "";
        do {
            text = sc.nextLine();
        }
        while (text.length() < 1);
        return text;
	}
	
	 //get integer
    public int getInt(String message) {
        display.shout(message);
        try {
            return input.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            display.shout("Invalid input, please try again.\n");
            getInt(message);
        }
        return -1;
    }

}
