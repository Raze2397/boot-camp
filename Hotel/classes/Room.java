package classes;
import enumerations.RoomCategories;
import enumerations.RoomOccupancy;
import enumerations.RoomStatus;
public class Room {
	private RoomCategories category;
	private RoomOccupancy occupancy;
	private RoomStatus status;
	private double roomRate;
	private boolean hasWifi;
	private int reservedDaysLeft;
	public Room(RoomCategories category,RoomOccupancy occupancy,RoomStatus status,double roomRate,boolean hasWifi) {
		
		this.category = category;
		this.occupancy = occupancy;
		this.status = status;
		this.roomRate = roomRate;
		this.hasWifi = hasWifi;
		reservedDaysLeft=0;
		
	}
	public void reserveRoom(short days) {
		setStatus(RoomStatus.OCCUPIED);
	    setReservedDaysLeft(days);
		
	}
	
	public RoomCategories getCategory() {
		return category;
	}
	
	public void setCategory(RoomCategories category) {
		this.category = category;
	}
	
	public RoomOccupancy getOccupancy() {
		return occupancy;
	}
	
	public void setOccupancy(RoomOccupancy occupancy) {
		this.occupancy = occupancy;
	}
	
	public RoomStatus getStatus() {
		return status;
	}
	
	
	
	public void setStatus(RoomStatus status) {
		this.status = status;
	}
	public double getRoomRate() {
		return roomRate;
	}
	
	public void setRoomRate(double roomRate) {
		this.roomRate=roomRate;
	}
	
	public boolean getHasWifi() {
		return hasWifi;
	}
	
	public void setHasWifi(boolean hasWifi) {
		this.hasWifi = hasWifi;
	}
	public int getReservedDaysLeft() {
		return reservedDaysLeft;
	}
	public void setReservedDaysLeft(int reservedDaysLeft) {
		this.reservedDaysLeft = reservedDaysLeft;
	}
}
