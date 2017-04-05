// Chapter 2, exercise 12
// Jim Morris

import java.util.Scanner;

public class ch2_e12 {
	
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Input start and end times as strings
		System.out.print ("Enter the start time in 24-hour format (hh:mm:ss) > ");
		String rawstart = console.nextLine();
		System.out.print ("Enter the end time in the same way > ");
		String rawend = console.nextLine();
		
		// Separate strings into an arrays
		String[] splstart = rawstart.split(":");
		String[] splend = rawend.split(":");
		
		// Convert string values into integers
		int[] numstart = new int[splstart.length];
		int[] numend = new int[splend.length];
		
		int i; // initialize counter variable
		
		for (i = 0; i < 3; i++) { // ensure that only the first three numbers are used
	         numstart[i] = Integer.parseInt(splstart[i]);
	         numend[i] = Integer.parseInt(splend[i]);
	      }
				
		// Calculate elapsed time
		
		// Seconds
		int stsec = numstart[2];
		int ensec = numend[2];
		
		// Ensure the subtraction returns a positive integer
		if ((ensec == 0 && ensec != stsec) || ensec < stsec) {
			ensec += 60;
		}
		
		int elpsec = ensec - stsec;
		
		// Minutes
		int stmin = numstart[1];
		int enmin = numend[1];
		int elpmin;
		
		// Ensure subtraction returns positive integer
		if ((enmin == 0 && enmin != stmin) || enmin < stmin) {
			enmin += 60;
		}
		
		// Correctly calculate partial minutes
		if (numend[2] < numstart[2]) {
			elpmin = enmin - stmin - 1;
		}
		else {
			elpmin = enmin - stmin;
		}
		
		// Hours
		int sthour = numstart[0];
		int enhour = numend[0];
		int elphour;
		
		// Ensure subtraction returns positive integer
		if ((enhour == 0 && enhour != sthour) || enhour < sthour) {
			enhour += 24;
		}
		
		// Correctly calculate partial hours
		if (numend[1] < numstart[1]) {
			elphour = enhour - sthour - 1;
		}
		else {
			elphour = enhour - sthour;
		}
		
		// Print elapsed time as hh:mm:ss
		System.out.println (
			"\nElapsed time > "
			+ (elphour < 10 ? "0" : "") + elphour // double-digit format
			+ ":"
			+ (elpmin < 10 ? "0" : "") + elpmin
			+ ":"
			+ (elpsec < 10 ? "0" : "") + elpsec
		);
		
		// Calculate elapsed time in seconds
		int allsec = (elphour * 60 * 60) + (elpmin * 60) + elpsec;
		
		System.out.println ("\nElapsed time in seconds > " + allsec);
		
	}
	
}