package battleship.model;

import java.util.ArrayList;


public class ShipConfiguration {
	private ArrayList<Ship> shipManifest;
	private String []shipTypes={"Aircraft Carrier","Battleship","Submarine","Destroyer","Patrol Boat"};
	private String []shipSymbol={"AC","BS","SUB","DES","PB"};
	private int []shipSize={5,4,3,3,2};
	private int []shipFrequency={1,2,2,2,4};
	
	public void createManifest() {	
		shipManifest=new ArrayList<Ship>();
		
		for (int i=0; i < shipTypes.length; i++) {
			for (int k=0; k < shipFrequency[i]; k++) {
				Ship as=new Ship();
				as.setShipType(shipTypes[i]);
				as.setShipSize(shipSize[i]);
				as.setSymbol(shipSymbol[i]+"_"+k);
				shipManifest.add(as);
			}
		}

	}
	public Ship []getManifest() {
		return shipManifest.toArray(new Ship[0]);
	}
	
	public void printManifest() {
		for (int i=0; i < shipManifest.size(); i++) {
			Ship s=shipManifest.get(i);
			System.out.println(s.getShipType()+" "+s.getShipSize()+" "+s.getSymbol());
		}
	}
		
	public static void main(String []args) {
		ShipConfiguration s=new ShipConfiguration();
		s.createManifest();
		s.printManifest();
	}
}
