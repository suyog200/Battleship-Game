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
    public Integer getInt(String message) {
        display.shout(message);
        try {
            return input.nextInt();
        } catch (NumberFormatException | InputMismatchException e) {
            display.shout("Invalid input, please try again.\n");
            getInt(message);
        }
        return -1;
    }
    
  //to convert placements
    public Integer[] convertPlacement(String coordinate) {
        try {
            while (!coordinateCheck(coordinate)) {
                coordinate = getString("Invalid input, try again! ").toLowerCase();
            }
            char[] letters = "abcdefghij".toCharArray();
            String letter = coordinate.substring(0, 1).toLowerCase();
            Integer row = new String(letters).indexOf(letter);
            Integer col = Integer.parseInt(coordinate.substring(1)) - 1;
            return new Integer[]{col, row};
        } catch (NumberFormatException e) {
            return null;
        }
    }

    //to check the coordinates
    public Boolean coordinateCheck(String coordinate) {
        if (coordinate.length() == 2) {
            return coordinate.matches("\\D\\d");
        } else if (coordinate.length() == 3) {
            return coordinate.matches("\\D\\d\\d");
        }
        return false;
    }

}
