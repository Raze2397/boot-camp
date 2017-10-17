package classes;

import enumerations.RoomCategories;
import enumerations.RoomOccupancy;
import enumerations.RoomStatus;

public class Luxury extends Room {

	private static final double DEFAULT_RATE = 200;
	
	public Luxury(RoomOccupancy occupancy) {
		super(RoomCategories.LUXURY, occupancy, RoomStatus.VACANT, DEFAULT_RATE, false);
		if(occupancy==RoomOccupancy.DOUBLE) {
			setRoomRate(DEFAULT_RATE*2);
			
		}

		
	}
	public double getDefaultRate() {
		return DEFAULT_RATE;
	}

}
