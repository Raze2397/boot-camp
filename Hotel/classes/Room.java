package classes;

import java.util.Scanner;

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

	public Room(RoomCategories category, RoomOccupancy occupancy, RoomStatus status, double roomRate, boolean hasWifi) {

		this.category = category;
		this.occupancy = occupancy;
		this.status = status;
		this.roomRate = roomRate;
		this.hasWifi = hasWifi;
		reservedDaysLeft = 0;

	}

	public void reserveRoom(short days) {

		if (status == RoomStatus.OCCUPIED) {
			System.out.println("The room is occupied, therefore you cannot reserve it.");
			return;
		}
		System.out.println("Are you sure that you want to reserve that room for " + days + " days?");
		System.out.println("Type 1 to confirm or 0 to cancel");
		Scanner scanner = new Scanner(System.in);
		short choice;
		do {
			choice = scanner.nextShort();
			if (choice != 0 && choice != 1)
				System.out.println("Invalid choice, please try again!");
		} while (choice != 0 && choice != 1);

		if (choice == 0) {
			System.out.println("Room was not reserved!");
			System.out.println();
		} else {
			setStatus(RoomStatus.OCCUPIED);
			setReservedDaysLeft(days);
			System.out.println("Room was successfully reserved");
			System.out.println();
		}
	}

	public void cancelReservation() {

		if (status == RoomStatus.VACANT) {
			System.out.println("The room is not occupied. Action terminated.");
			System.out.println();
			return;
		}
		System.out.println("Are you sure that you want to cancel the reservation for that room?");
		System.out.println("Type 1 to confirm or 0 to cancel");
		Scanner scanner = new Scanner(System.in);
		short choice;
		do {
			choice = scanner.nextShort();
			if (choice != 0 && choice != 1)
				System.out.println("Invalid choice, please try again!");
		} while (choice != 0 && choice != 1);

		if (choice == 0) {
			System.out.println("Room reservation was not canceled!");
			System.out.println();
		} else {
			setStatus(RoomStatus.VACANT);
			setReservedDaysLeft(0);
			System.out.println("Room reservation was successfully canceled");
			System.out.println();
		}

	}

	public void displayRoomInfo() {
		System.out.println("Room type: " + category.name());
		System.out.println("Occupancy type: " + occupancy.name());
		System.out.println("Has Wifi: " + hasWifi);
		System.out.println("Room fee per night is: " + roomRate + " euro");
		System.out.println("Current status: " + status.name());
		if (status == RoomStatus.OCCUPIED) {
			System.out.println("Will be vacant after " + reservedDaysLeft + " days");
		}
		System.out.println();

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
		this.roomRate = roomRate;
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
