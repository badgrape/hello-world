package assign04;

import java.util.Scanner;

public class DayUI {
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[]args) {
		
		System.out.print("Enter a day of the week (\"today\" also works): ");
		
		// Create new day object
		Day day = new Day(console.next());
		
		// Ensure object is created with correct values
		while (!day.valid()) {
			
			System.out.print("Invalid entry.\nEnter minimum the first three letters of a real day: ");
			day.setDay(console.next());
			
		}
		
		// Get parameter for futureDay
		System.out.print("How many days ahead do you want to look? ");
		int elapsed = console.nextInt();
		
		// Day indexes
		int userGen = day.thisDay();
		int calcNext = day.nextDay();
		int calcPrev = day.prevDay();
		int calcFutur = day.futureDay(elapsed);
		
		// Print abbreviated days with printDay
		System.out.println("\nAbbreviated days, printed with printDay:");
		System.out.print("- The day you entered: ");
		day.printDay(userGen, 0);
		System.out.print("\n- The day after: ");
		day.printDay(calcNext, 0);
		System.out.print("\n- The day before: ");
		day.printDay(calcPrev, 0);
		System.out.print("\n- " + elapsed + " days into the future: ");
		day.printDay(calcFutur, 0);
		
		// Print full days in string with returnDay
		System.out.println("\n\nFull-length days, added to string with returnDay:");
		System.out.printf(
			"\"The day after %s is %s, and the day before is %s. %d days after %s will be %s.\"",
			day.returnDay(userGen, 1),
			day.returnDay(calcNext, 1),
			day.returnDay(calcPrev, 1),
			elapsed,
			day.returnDay(userGen, 1),
			day.returnDay(calcFutur, 1)
		);
		
	}
	
}