package board;

public class Square {
	private boolean isShip, isHit, isHidden, isSunk;
    private final int x, y;
    
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.isShip = false;
        this.isHit = false;
        this.isHidden = false;
        this.isSunk = false;
    }
    
	public boolean isShip() {
		return isShip;
	}
	public void setShip(boolean isShip) {
		this.isShip = isShip;
	}
	public boolean isHit() {
		return isHit;
	}
	public void setHit(boolean isHit) {
		this.isHit = isHit;
	}
	public boolean isHidden() {
		return isHidden;
	}
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}
	public boolean isSunk() {
		return isSunk;
	}
	public void setSunk(boolean isSunk) {
		this.isSunk = isSunk;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
