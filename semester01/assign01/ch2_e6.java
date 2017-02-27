// Chapter 2, exercise 6
// Jim Morris

import java.util.Scanner;

public class ch2_e6 {

    static Scanner console = new Scanner(System.in);    
	
	public static void main(String[] args) {
				
		System.out.print ("Enter a decimal number: ");
        
        double decm = console.nextDouble();
        
        // Round to nearest whole number
		double rndnum = Math.round(decm);
		
		// Convert double to integer
		int whlnum = (int) (rndnum);
		
        System.out.println("\n" + decm + " rounded to the nearest integer = " + whlnum);
	}

}