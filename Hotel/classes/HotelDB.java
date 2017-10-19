package classes;

import java.util.Scanner;

import classes.Room;
import enumerations.RoomOccupancy;
import enumerations.RoomStatus;

public class HotelDB {
	private Room[] rooms;
	private int initializedRoomsCount;
	public HotelDB(int roomCount) {
		rooms = new Room[roomCount];
		initializedRoomsCount=0;
		Scanner scanner = new Scanner(System.in);
		
		for(int counter=0;counter<roomCount;counter++) {
			short roomChoice;
			do {
			roomChoice = scanner.nextShort();
			if(roomChoice<1 || roomChoice>5)System.out.println("Invalid room ID, please try again!");
			}while(roomChoice<1 || roomChoice>5);
			addRoom(roomChoice);
		}
		scanner.close();
	}

	

	public void cancelReservation(Room room) {
		room.setStatus(RoomStatus.VACANT);
		room.setReservedDaysLeft(0);
	}

	public void displayRoomCharge(Room room) {
		System.out.println(room.getRoomRate() * room.getReservedDaysLeft());
	}

	public static void main(String[] args) {
		// System.out.println("done");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of rooms in your hotel");
		HotelDB expo = new HotelDB(scanner.nextShort());
		expo.rooms[1].reserveRoom((short)2);
		expo.displayRoomCharge(expo.rooms[1]);

	}
	
	public void addRoom(short roomType) {
		
		switch(roomType) {
		case 1: {
			rooms[initializedRoomsCount++] = new Luxury(RoomOccupancy.SINGLE);
			break;
		}
		case 2: {
			rooms[initializedRoomsCount++] = new Luxury(RoomOccupancy.DOUBLE);
			break;
		}
		case 3: {
			rooms[initializedRoomsCount++] = new Delux(RoomOccupancy.SINGLE);
			break;
		}
		case 4: {
			rooms[initializedRoomsCount++] = new Delux(RoomOccupancy.DOUBLE);
			break;
		}
		case 5: {
			rooms[initializedRoomsCount++] = new SuperDelux();
			break;
		}
		}
	}

}
