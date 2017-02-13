// Chapter 5, exercise 1
// Jim Morris

import java.util.Scanner;

public class ch5_ex1 {
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter an integer of any length: ");
		String strnums = console.next();
		
		char fakenum; // numbers as characters
		String indvnums = ""; // digits separated by spaces
		
		int realnum; // integers
		int sum = 0; // sum of integers
		
		int i = 0; // counter
				
		while (i < strnums.length()) {
			
			// Extract individual characters
			fakenum = strnums.charAt(i);
			
			if (fakenum != '-') { // ignore negative operator
				
				// Generate string of individual digits
				indvnums += fakenum + " ";
			
				// Convert individual characters to integers and calculate sum
				realnum = fakenum - '0';
				sum += realnum;
				
			}
			
			i++;
			
		}
		
		// Output
		System.out.println("Individual digits: " + indvnums);
		System.out.println("Sum: " + sum);
	}
	
}