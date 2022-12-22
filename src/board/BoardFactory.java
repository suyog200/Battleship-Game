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
        return new Integer[]{new Random().nextInt(player.getBoard().getOcean().length), new Random().nextInt(player.getBoard().getOcean().length)};
    }
    
    //Manual placement of ship
    public void manualPlacement(Player player, ShipType shipType) {
    	display.shout(String.format("Time to place your %s (size: %s), %s" , shipType, shipType.getLength(), player.name));
        String direction = isInputHorizontalOrVertical();
        String coordinate = input.getString(String.format("Choose a coordinate, %s: ", player.name));
        Integer[] placement = input.convertPlacement(coordinate);
        while (!validPlace(player, shipType.getLength(), placement, direction)){
            placement = input.convertPlacement(input.getString("Invalid placement. Choose another coordinate: "));
        } setPlacement(placement, player, direction, shipType);
    }
    
    private Boolean checkEdgeNeighbours(Integer[] coordinate, String direction, IPlayer player, Integer shipSize) {
    	if (direction.equals("h")) {
            Integer[] leftNeighbour = new Integer[]{coordinate[0], coordinate[1] - 1};
            Integer[] rightNeighbour = new Integer[]{coordinate[0], coordinate[1] + shipSize};
            if (leftNeighbour[1] < 0) return player.getBoard().isPlacementOk(rightNeighbour);
            else if (rightNeighbour[1] > player.getBoard().BOARD_SIZE) return player.getBoard().isPlacementOk(leftNeighbour);
            else return player.getBoard().isPlacementOk(leftNeighbour) && player.getBoard().isPlacementOk(rightNeighbour);
        } else {
        	Integer[] topNeighbour = new Integer[]{coordinate[0] - 1, coordinate[1]};
        	Integer[] bottomNeighbour = new Integer[]{coordinate[0] + shipSize, coordinate[1]};
            if (topNeighbour[0] < 0) return player.getBoard().isPlacementOk(bottomNeighbour);
            else if (bottomNeighbour[0] > player.getBoard().BOARD_SIZE) return player.getBoard().isPlacementOk(topNeighbour);
            else return player.getBoard().isPlacementOk(topNeighbour) && player.getBoard().isPlacementOk(bottomNeighbour);
        }
    }
    
    //check for coordinates, shiplength, direction, shiptype.
    //return true if it's valid place to put ship
    public Boolean validPlace(IPlayer player, Integer shipSize, Integer[] coordinate, String direction) {
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
    
    //Check placement of neighbors ship
    public Boolean checkNeighbours(Integer[] coordinate, String direction, IPlayer player) {
        if (direction.equals("h")) {
        	Integer[] topNeighbour = new Integer[]{coordinate[0] - 1, coordinate[1]};
        	Integer[] bottomNeighbour = new Integer[]{coordinate[0] + 1, coordinate[1]};
            if (topNeighbour[0] < 0) return player.getBoard().isPlacementOk(bottomNeighbour);
            else if (bottomNeighbour[0] >= player.getBoard().BOARD_SIZE) return player.getBoard().isPlacementOk(topNeighbour);
            else return player.getBoard().isPlacementOk(topNeighbour) && player.getBoard().isPlacementOk(bottomNeighbour);
        }
        else {
        	Integer[] leftNeighbour = new Integer[]{coordinate[0], coordinate[1] - 1};
        	Integer[] rightNeighbour = new Integer[]{coordinate[0], coordinate[1] + 1};
            if (leftNeighbour[1] < 0) return player.getBoard().isPlacementOk(rightNeighbour);
            else if (rightNeighbour[1] >= player.getBoard().BOARD_SIZE) return player.getBoard().isPlacementOk(leftNeighbour);
            else return player.getBoard().isPlacementOk(leftNeighbour) && player.getBoard().isPlacementOk(rightNeighbour);
        }
    }
    
    //Setting placement of ship
    public void setPlacement(Integer[] coordinate, IPlayer player, String direction, ShipType shipType) { //Marks chosen Squares as SHIP.
        ArrayList<Square> squares = new ArrayList<>();
        for (int i=0; i<shipType.getLength(); i++) {
            if (direction.equals("h")) {
                player.getBoard().getOcean()[coordinate[0]][coordinate[1] + i].setShip();
                squares.add(player.getBoard().getOcean()[coordinate[0]][coordinate[1] + i]);
            } else {
                player.getBoard().getOcean()[coordinate[0] + i][coordinate[1]].setShip();
                squares.add(player.getBoard().getOcean()[coordinate[0] + i][coordinate[1]]);
            }
        }
        Ship ship = new Ship(squares, shipType);
        player.addShip(ship);
    }
	
    //Returns input from Input.java, validate and set h or v if input is true
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
