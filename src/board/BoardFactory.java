package board;

import java.util.ArrayList;
import java.util.Random;

import player.IPlayer;
import player.Player;
import ships.Ship;
import ships.ShipType;
import utilities.Display;
import utilities.Input;

public class BoardFactory {
    Input input = new Input();
    Display display = new Display();
    
    //Random placement of the ships
    public void randomPlacement(IPlayer player, ShipType shipType) {
        display.shout(String.format("Time to place your %s (size: %s), %s" , shipType, shipType, player.name));
        String[] directions = {"h", "v"};
        String direction = directions[new Random().nextInt(2)];
        Integer[] coordinate = getCoordinate(player);
        while (!validPlace(player, shipType.getLength(), coordinate, direction)) {
            coordinate = getCoordinate(player);
        }
        setPlacement(coordinate, player, direction, shipType);
    }
    
    private Integer[] getCoordinate(IPlayer player) {
        return null;
    }
    
    public void manualPlacement(Player player, ShipType shipType) {
    	
    }
    
    private Boolean validPlace(IPlayer player, Integer shipSize, int[] coordinate, String direction) {
		return null;
    	
    }
    
    public Boolean checkEdgeNeighbours(int[] coordinate, String direction, IPlayer player, Integer shipSize) {
		return null;
    	
    }
    
    public Boolean checkNeighbours(int[] coordinate, String direction, IPlayer player) {
		return null;
    }
    
    public void setPlacement(int[] coordinate, IPlayer player, String direction, ShipType shipType) { //Marks chosen Squares as SHIP.
    	
    }
	
    public String isInputHorizontalOrVertical() {
        Boolean isOk = false;
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
