package array;

import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the desired array size and press ENTER key.");
		int length = sc.nextInt();
		int[] testArray = new int[length];
		boolean firstPrintedNumber = true;
		System.out.println("Please enter the numbers for each slot in the array, each followed by an ENTER key.");
		for (int iterator = 0; iterator < length; iterator++) {
			testArray[iterator] = sc.nextInt();
		}

		for (int iterator = 1; iterator < length - 1; iterator++) {
			int leftSum = 0;
			int rightSum = 0;
			for (int innerIterator = 0; innerIterator < iterator; innerIterator++) {
				leftSum = leftSum + testArray[innerIterator];
			}
			for (int innerIterator = iterator + 1; innerIterator < length; innerIterator++) {
				rightSum = rightSum + testArray[innerIterator];
			}
			if (leftSum == rightSum) {
				if (firstPrintedNumber==true) {
					System.out.print("The indexes that match the requirements are: " + iterator);
					firstPrintedNumber=false;
				} else {
					System.out.print(" , " + iterator);
				}
			}
		}
		if(firstPrintedNumber==true) {
			System.out.println("There were no indexes that match the requirements.");
		}
		sc.close();
	}

}
