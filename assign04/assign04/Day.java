package assign04;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Day {

	// Instance variables
	
	public int index; // day number: Sunday is 0, Saturday 6
	public String abbr; // three-character day; needed to validate user input
	
	// String values per day index: used in setDay, returDay and printDay
	
	private final String[][] daysOfWeek = { // day values per index
		{"Sun", "Sunday"},
		{"Mon", "Monday"},
		{"Tue", "Tuesday"},
		{"Wed", "Wednesday"},
		{"Thu", "Thursday"},
		{"Fri", "Friday"},
		{"Sat", "Saturday"}
	};

	// Constructors
	
		// Default Day object: today
		
		public Day() {
			
			setDay(today());
			
		}
		
		// User-defined Day object
		
		public Day(String day) {
		
			setDay(day);
			
		}
	
	// Get today's day
	
	public String today() {
		
		Date now = new Date();
		
		SimpleDateFormat today = new SimpleDateFormat("E");
		String day = today.format(now);
		
		return day;
		
	}
	
	// Set the day
	
	public void setDay(String day) {
		
		// User must enter a string containing at least three characters
		if (day.length() >= 3) {
			
			// If user enters (minimum first three chars of) "today," use today's day
			if (day.substring(0,3).toLowerCase().equals("tod")) {
				day = today();
			}
			
			// Saves first three characters of user input, captialize first letter
			day = day.substring(0,1).toUpperCase() + day.substring(1,3).toLowerCase();
				
			// To properly create Day object,
			// value of day must match an abbreviated day string
			for (int i = 0; i < daysOfWeek.length; i++) {
					
				if (day.equals(daysOfWeek[i][0])) {
					index = i;
					abbr = day;
				}
					
			}
			
		}
		
	}
	
	// Validate user input
	
	public boolean valid() {
		
		boolean realDay = true;
		
		// Returns false if object is not created correctly
		if (abbr == null) {
			realDay = false;
		}
		
		return realDay;
	}
	
	
	// Return day as string value
	// First parameter: day index, original or re-calculated
	// Second parameter: 0 for abbreviation, 1 for complete word
	
	public String returnDay(int day, int length) {
		
		return(daysOfWeek[day][length]);
		
	}
	
	// Similar to returnDay, except print value on a single line
	
		public void printDay(int day, int length) {
			
			System.out.print(daysOfWeek[day][length]);
			
		}
	
	// Return index assigned at object creation
	
	public int thisDay() {
		
		return index;
		
	}
	
	// Calculate days
	// Parameter: number of days in future (+) or past (-)
	
	public int calcDay(int modifier) {
					
		// Calculate days elapsed
		int calcIndex = (index + modifier) % daysOfWeek.length;
			
		// Correct negative values, e.g., Sunday (0) - 1 = Saturday (6)
		if (calcIndex < 0) {
				calcIndex += 7;
		}
			
		return calcIndex;
					
	}
		
	// Return index of next day
	
	public int nextDay() {
				
		int next = calcDay(1);
		
		return next;
		
	}
	
	// Return index of previous day
	
	public int prevDay() {
				
		int previous = calcDay(-1);
		
		return previous;
				
	}
	
	// Return index of a day in the future
	// Parameter: number of days into the future
	// Also calculates into the past if elapsed value is negative
	
	public int futureDay(int elapsed) {
		
		int future = calcDay(elapsed);
		
		return future;
	
	}
		
}