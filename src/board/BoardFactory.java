package board;

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
        return new Integer[]{new Random().nextInt(player.getBoard().getOcean().length), new Random().nextInt(player.getBoard().getOcean().length)};
    }
    
    public void manualPlacement(Player player, ShipType shipType) {
    	
    }
    
    private Boolean validPlace(IPlayer player, Integer shipSize, Integer[] coordinate, String direction) {
		return null;
    	
    }
    
    public Boolean checkEdgeNeighbours(Integer[] coordinate, String direction, IPlayer player, Integer shipSize) {
    	Integer[] targetCoordinate;
        try {
            for (int i=0; i<shipSize; i++) {
                if (direction.equals("h")) {
                    targetCoordinate = new Integer[]{player.getBoard().getOcean()[coordinate[0]][coordinate[1] + i].getX(),player.getBoard().getOcean()[coordinate[0]][coordinate[1] + i].getY()};
                } else {
                    targetCoordinate = new Integer[]{player.getBoard().getOcean()[coordinate[0] + i][coordinate[1]].getX(),player.getBoard().getOcean()[coordinate[0] + i][coordinate[1]].getY()};
                }
                if (!player.getBoard().isPlacementOk(targetCoordinate) || !checkNeighbours(targetCoordinate, direction, player)) return false;
            } if (!checkEdgeNeighbours(coordinate, direction, player, shipSize)) return false;
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }
    
    public Boolean checkNeighbours(Integer[] coordinate, String direction, IPlayer player) {
		return null;
    }
    
    public void setPlacement(Integer[] coordinate, IPlayer player, String direction, ShipType shipType) { //Marks chosen Squares as SHIP.
    	
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
