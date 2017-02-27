package assign04;

import java.util.Scanner;

public class SwimmingPoolUI{
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter the dimensions of a swimming pool in feet (length width depth): ");
		
		double ln = console.nextDouble();
		double wd = console.nextDouble();
		double dp = console.nextDouble();
		
		// Creating object pool, setting values for length, width and depth
		// Fill and drain rates set below
		SwimmingPool pool = new SwimmingPool(ln, wd, dp);
		
		// Calculate and print volume of pool
		System.out.printf("The pool can hold %.1f gallons.%n", pool.getVolume());
		
		System.out.print("Number of gallons already in the pool: ");
		
		double existingWater = console.nextDouble();
		
		// Variables for conditional structures
		
		char operation = 'f'; // (f)ill or (d)rain? default is fill	
		char answer; // fill or drain (p)artially or (c)ompletely?
		
		// Time frame to fill or drain
		// Parameter for amountFilledOverTime and amountEmptiedOverTime
		double time;
		
		// If there's already some water in the pool, give option to drain
		if (existingWater > 0.0) {
			
			System.out.print("\n(F)ill or (d)rain the pool? ");
			
			// Accept single-letter and full-word input
			operation = console.next().toLowerCase().charAt(0);
		}
		
		// Use the fill methods
		if (operation == 'f') {
			
			System.out.print("\nFill it (p)artially or (c)ompletely? ");
			
			// Single-letter or full-word input
			answer = console.next().toLowerCase().charAt(0);
			
			double fillVolume = 0; // amount to fill
			
			// Fill the entire pool, or specify number of gallons
			if (answer == 'c') {
				fillVolume = pool.getVolume();
			}
			
			else if (answer == 'p') {
				System.out.print("How many gallons? ");
				fillVolume = console.nextDouble();
			}
			
			// Calculate amount of water needed
			double waterNeeded = pool.waterToFill(existingWater, fillVolume);
			
			System.out.printf("You will need %.1f gallons to do the job.%n", waterNeeded);
			
			System.out.print("How quickly (gallons per minute) can you fill the pool? ");
			double fillRate = console.nextDouble();
			
			// Set fillRate for pool object
			pool.setFill(fillRate);
			
			// Calculate how long it will take to fill pool, given fill rate
			double timeToFill = pool.timeToFill(waterNeeded);
			
			System.out.printf("It will take you %.1f minutes to add %.1f gallons.%n",
				timeToFill, waterNeeded);
			
			System.out.print("How much time (minutes) do you have? ");
			time = console.nextDouble();
			
			// Calculate how water can be filled in a specific time frame
			double fillOverTime = pool.amountFilledOverTime(time);
			
			System.out.printf("In %.0f minutes, you can add %.1f gallons.", time, fillOverTime);
			
		}
		
		else if (operation == 'd') {
			
			System.out.print("\nHow quickly (gallons per minute) can you drain the pool? ");
			double drainRate = console.nextDouble();
			
			// set drainRate for pool object
			pool.setDrain(drainRate);
			
			System.out.print("Drain (p)artially or (c)ompletely? ");
			
			answer = console.next().toLowerCase().charAt(0);
			
			double drainVolume = 0;
			
			// Drain entire pool, or specify number of gallons to drain
			if (answer == 'c') {
				drainVolume = existingWater;
			}
			
			else if (answer == 'p') {
				System.out.print("How many gallons? ");
				drainVolume = console.nextDouble();
			}
			
			// Calculate how long it will take to drain the pool, given the drain rate
			double timeToDrain = pool.timeToEmpty(drainVolume);
			
			System.out.printf("It will take you %.1f minutes to drain %.1f gallons.%n",
				timeToDrain, drainVolume);
			
			System.out.print("How much time (minutes) do you have? ");
			time = console.nextDouble();
			
			// How much water can be drained in a specific amount of time
			double drainOverTime = pool.amountEmptiedOverTime(time);
			System.out.printf("In %.0f minutes, you can drain %.1f gallons.", time, drainOverTime);
			
		}
		
	}
	
}