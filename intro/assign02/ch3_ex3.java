// Chapter 3, exercise 3
// Jim Morris

import java.util.Scanner;

public class ch3_ex3 {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		// Get weight in kilograms
		System.out.print("Enter your weight in kilograms: ");
		
		Double kilos = console.nextDouble();
		
		// Calculate weight in pounds
		Double pounds = kilos * 2.2;
		
		// Output both weights to two decimal places
		System.out.printf("%n%.2f kilograms equals %.2f pounds.", kilos, pounds);
		
	}
	
}