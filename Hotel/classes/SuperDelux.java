package classes;

import enumerations.RoomCategories;
import enumerations.RoomOccupancy;
import enumerations.RoomStatus;

public class SuperDelux extends Room {
	private static final double DEFAULT_RATE = 400;
	public SuperDelux() {
		super(RoomCategories.SUPERDELUX, RoomOccupancy.SINGLE, RoomStatus.VACANT, DEFAULT_RATE, true);
		
	}
	public double getDefaultRate() {
		return DEFAULT_RATE;
	}

}
