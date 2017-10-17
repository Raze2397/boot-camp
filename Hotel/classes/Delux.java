package classes;

import enumerations.RoomCategories;
import enumerations.RoomOccupancy;
import enumerations.RoomStatus;

public class Delux extends Room {
	private static final double DEFAULT_RATE=300;
	public Delux(RoomOccupancy occupancy) {
		super(RoomCategories.DELUX, occupancy, RoomStatus.VACANT, DEFAULT_RATE, true);
		if(occupancy==RoomOccupancy.DOUBLE) {
			setRoomRate(DEFAULT_RATE*2);
		}
	}
	public double getDefaultRate() {
		return DEFAULT_RATE;
	}

}


