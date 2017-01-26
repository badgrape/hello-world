// Chapter 3, exercise 3
// Jim Morris

import java.util.Scanner;

public class ch3_ex3 {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		System.out.print("Enter your weight in kilograms: ");
		
		Double kilos = console.nextDouble();
		
		Double pounds = kilos * 2.2;
		
		System.out.printf("%n%.2f kilograms equals %.2f pounds.", kilos, pounds);
		
	}
	
}