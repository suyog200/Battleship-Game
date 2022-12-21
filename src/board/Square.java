package board;

public class Square {
	private enum SquareStatus {
		EMPTY("~ "), SHIP("<> "), HIT("#"), MISS("X"), SUNK("💀");

		String squareCharatcter;

		SquareStatus(String squareCharatcter) {
			this.squareCharatcter = squareCharatcter;
		}

		public String getCharacter() {
			return squareCharatcter;
		}
	}

	private Boolean isShip, isHit, isHidden, isSunk;
	private final Integer x, y;

	// Constructor for each 10x10 object
	public Square(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		this.isShip = false;
		this.isHit = false;
		this.isHidden = false;
		this.isSunk = false;
	}

	public Boolean isShip() {
		return isShip;
	}

	public void setShip(Boolean isShip) {
		this.isShip = isShip;
	}

	public Boolean isHit() {
		return isHit;
	}

	public void setHit(Boolean isHit) {
		this.isHit = isHit;
	}

	public Boolean isHidden() {
		return isHidden;
	}

	public void setHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}

	public void setVisibility(Boolean state) {
		this.isHidden = state;
	}

	public Boolean isSunk() {
		return isSunk;
	}

	public void setSunk(Boolean isSunk) {
		this.isSunk = isSunk;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}
}
