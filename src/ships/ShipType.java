package ships;

//different types of ships
public enum ShipType {
  Carrier(5),
  Cruiser(4),
  Battleship(3),
  Submarine(3),
  Destroyer(2)
  ;

	//to set ship length
  Integer length;

  ShipType(Integer length) {
      this.length = length;
  }

  public Integer getLength() {
      return length;
  }

}


