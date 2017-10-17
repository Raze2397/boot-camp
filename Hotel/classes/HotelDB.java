package classes;
import classes.Room;



import enumerations.RoomStatus;
public class HotelDB {
	private Room[] rooms;
	
	public HotelDB(int roomCount) {
		rooms = new Room[roomCount];
	}
	
	public void reserveRoom(Room room,int days) {
		room.setStatus(RoomStatus.OCCUPIED);
		room.setReservedDaysLeft(days);
		displayRoomCharge(room);
	}
	public void cancelReservation(Room room) {
		room.setStatus(RoomStatus.VACANT);
		room.setReservedDaysLeft(0);
	}
	
	public void displayRoomCharge(Room room) {
		System.out.println(room.getRoomRate()*room.getReservedDaysLeft());
	}
	
	
}
