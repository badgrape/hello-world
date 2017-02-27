// Chapter 2, exercise 7
// Jim Morris

import java.util.Scanner;

public class ch2_e7 {
	
	static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print ("Enter your five test scores, separated by spaces: ");
		
		// Accept test scores as string
		String fvscores = console.nextLine();
		
		// Separate string into an array
		String[] splscores = fvscores.split(" ");
		
		int i; // Initialize counter variable for loops
		
		// Convert string values into decimals
		double[] numscores = new double[splscores.length]; 
		
		for (i = 0; i < 5; i++) { // ensures that only the first five entries are used
	         numscores[i] = Double.parseDouble(splscores[i]);
	    }
		
		// Add the scores
		double sumscores = 0; // Initialize variable to hold the sum
		
		i = 0;
		
		while (i < numscores.length) {
			sumscores += numscores[i];
			i++;
		}
        
		// Calculate the average		
		double avgscore = sumscores / 5;
		
		// Round to one decimal place
		double rndavg = Math.round(avgscore * 10.0) / 10.0;
		        
        System.out.println("\nYour average is " + rndavg);
		
	}
	
}