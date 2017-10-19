package classes;

import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Room;
import enumerations.RoomOccupancy;
import exceptions.InvalidChoiceException;
import exceptions.InvalidRoomTypeException;

public class HotelDB {
	private Room[] rooms;
	private int initializedRoomsCount;

	public HotelDB(int roomCount) {

		rooms = new Room[roomCount];
		initializedRoomsCount = 0;
		Scanner scanner = new Scanner(System.in);

		for (int counter = 0; counter < roomCount; counter++) {
			short roomChoice;
			do {
				try {
					System.out.println("Please enter the room type for room number " + (counter + 1)
							+ " (type 1 is Luxury SO, 2 is Luxury DO, 3 is Delux SO, 4 is Delux DO, 5 is SuperDelux)");
					roomChoice = scanner.nextShort();
					if (roomChoice < 1 || roomChoice > 5)
						throw new InvalidRoomTypeException("Invalid room type ID, please try again!");
					addRoom(roomChoice);
					break;
				} catch (InputMismatchException inputMismatch) {
					System.out.println("Invalid room type ID, please try again!");
					scanner.nextLine();
				} catch (InvalidRoomTypeException invalidRoomType) {
					System.out.println("Invalid room type ID, please try again!");
					scanner.nextLine();
				}

			} while (true);

		}

	}

	public void displayRoomCharge(Room room) {
		System.out.println(room.getRoomRate() * room.getReservedDaysLeft());
	}

	public void showRoomCatalogue() {
		for (short counter = 0; counter < initializedRoomsCount; counter++) {
			System.out.println("Room number: " + (counter + 1));
			rooms[counter].displayRoomInfo();
		}
	}

	public static void main(String[] args) {

		HotelDB myHotelDB = initialize();

		Scanner scanner = new Scanner(System.in);
		short choice;
		do {
			do {
				myHotelDB.showMenu();
				try {

					choice = scanner.nextShort();
					if (choice < 1 || choice > 4)
						throw new InvalidChoiceException("Invalid choice, please try again!");

					break;
				} catch (InputMismatchException inputMismatch) {
					System.out.println("Invalid choice, please try again!");
					scanner.nextLine();
				} catch (InvalidChoiceException invalidChoice) {
					System.out.println("Invalid choice, please try again!");
					scanner.nextLine();
				}

			} while (true);
			switch (choice) {
			case 1: {
				myHotelDB.showRoomCatalogue();
				break;
			}
			case 2: {
				System.out.println("Type in the room number, which you want to reserve.");
				short roomNumber;
				short days;
				try {
					roomNumber = scanner.nextShort();
					myHotelDB.rooms[roomNumber - 1].displayRoomInfo();
					System.out.println("Type in the number of days for which you want to reserve the room");
					days = scanner.nextShort();
					if (days < 1 || days > 365)
						throw new InvalidChoiceException("Invalid number of days");
					myHotelDB.rooms[roomNumber - 1].reserveRoom(days);
					break;
				} catch (InputMismatchException inputMismatch) {
					System.out.println("Invalid input. Action terminated.");
					scanner.nextLine();
					break;
				} catch (IndexOutOfBoundsException indexOutOfBounds) {
					System.out.println("Invalid room number. Action terminated.");
					scanner.nextLine();
					break;
				} catch (InvalidChoiceException invalidChoice) {
					System.out.println("Invalid number of days");
					scanner.nextLine();
					break;
				}

			}
			case 3: {

				System.out.println("Type in the room number, which you want to cancel the reservation for.");
				short roomNumber;

				try {
					roomNumber = scanner.nextShort();
					myHotelDB.rooms[roomNumber - 1].displayRoomInfo();
					if (roomNumber < 1 || roomNumber > myHotelDB.initializedRoomsCount) {
						System.out.println("Invalid room number. Action terminated.");
						break;
					}

					myHotelDB.rooms[roomNumber - 1].cancelReservation();
					break;

				} catch (InputMismatchException inputMismatch) {
					System.out.println("Invalid input. Action terminated.");
					scanner.nextLine();
					break;
				} catch (IndexOutOfBoundsException indexOutOfBounds) {
					System.out.println("Invalid room number. Action terminated.");
					scanner.nextLine();
					break;
				}

			}
			case 4: {
				System.out.println("Exiting Database...");
				break;
			}
			default: {
				System.out.println("Invalid choice, please try again!");
				break;
			}
			}

		} while (choice != 4);

		scanner.close();

	}

	public void showMenu() {
		System.out.println("Welcome to the menu, type in 1 to show room catalogue.");
		System.out.println("Type in 2 to reserve a room");
		System.out.println("Type in 3 to cancel a reservation");
		System.out.println("Type in 4 to exit the database");
	}

	public static HotelDB initialize() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of rooms in your hotel");
		short rooms;
		HotelDB database;
		do {
			try {
				rooms = scanner.nextShort();
				if (rooms == 0)
					rooms = -1;
				database = new HotelDB(rooms);
				break;
			} catch (InputMismatchException inputMismatch) {
				System.out.println("Invalid choice. Try again!");
				scanner.nextLine();
			} catch (NegativeArraySizeException negativeArraySize) {
				System.out.println("Invalid choice. Try again!");
				scanner.nextLine();
			}
		} while (true);

		return database;
	}

	public void addRoom(short roomType) {

		switch (roomType) {
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
