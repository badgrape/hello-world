// Chapter 5 exercises
// Jim Morris

package assign03;

import java.util.Scanner;

public class Chapter05 {
	
	public static Scanner console = new Scanner(System.in);
	
	// Exercise 1
	
	public static void exerciseOne() {
		
		System.out.print("Enter an integer of any length: ");
		String strNums = console.next();
		
		char fakeNum; // numbers as characters
		String indvNums = ""; // digits separated by spaces
		
		int realNum; // integers
		int sum = 0; // sum of integers
		
		int i = 0; // counter
				
		while (i < strNums.length()) {
			
			// Extract individual characters
			fakeNum = strNums.charAt(i);
			
			if (fakeNum != '-') { // ignore negative operator
				
				// Generate string of individual digits
				indvNums += fakeNum + " ";
			
				// Convert individual characters to integers and calculate sum
				realNum = fakeNum - '0';
				sum += realNum;
				
			}
			
			i++;
			
		}
		
		// Output
		System.out.println("Individual digits: " + indvNums);
		System.out.println("Sum: " + sum);
	}
		
	// Exercise 9
	
	public static void exerciseNine() {
				
		// (a) Prompt user to enter two integers
		
		int firstNum = 0;
		int secondNum = 0;
		
		int i = 0; // initialize counter
		
		while (i < 2) {
			
			// Counter value determines which number to request and store
			
			System.out.print("Enter the " + (i == 0 ? "first" : "second") + " number: ");
			
			if (i == 0) {
				firstNum = console.nextInt();
			}
			
			else {
				secondNum = console.nextInt();
				
				// Ensure first number is less than second
				while (firstNum > secondNum) {
					System.out.print("The second number must be greater than the first. Try again: ");
					secondNum = console.nextInt();
				}
			}
			
			i++;
		}
				
		// (b) Output all odd numbers between firstNum and secondNum inclusive
		
		int diffNums = secondNum - firstNum; // difference between first and second numbers; also used in c
		
		int currNum = 0; // current number in any iteration; also used in c
		
		String oddStr = ""; // string of odd numbers; used also in e
		
		i = 0; // reset counter
		
		while (i <= diffNums) {
			
			currNum = firstNum + i;
			
			// Add odd numbers to string
			if (currNum % 2 == 1 || currNum % 2 == -1) {
				oddStr += currNum + " ";
			}
			
			i++;
		
		}
		
		System.out.printf("%nOdd numbers between %d and %d: %s%n", firstNum, secondNum, oddStr);
				
		// (c) Output sum of all even numbers between firstNum and secondNum inclusive
		
		int sum = 0; // holds sum; also used in (e)
		
		i = 0; // reset counter
		
		while (i <= diffNums) {
			
			currNum = firstNum + i;
			
			// Add even numbers
			if (currNum % 2 == 0) {
				sum += currNum;
			}
			
			i++;
			
		}
		
		System.out.printf("%nSum of even numbers between %d and %d: %s%n", firstNum, secondNum, sum);
				
		// (d) Output all numbers between 1 and 10 and their squares
		
		String oneTen = ""; // string of numbers 1-10
		String oneTenSq = ""; // string of 1-10 squared
		
		i = 0; // reset counter
		
		while (i < 10) {
			i++;
			oneTen += i + " ";
			oneTenSq += (int)Math.pow(i,2) + " ";
		}
		
		System.out.println("\nNumbers between 1 and 10: " + oneTen);
		System.out.println("Numbers 1 to 10 squared: " + oneTenSq);
		
		// (e) Output sum of squares of all odd numbers between firstNum and secondNum inclusive
		// Unnecessarily complicated, but I wanted to practice working with string methods
		
		int indxSpc = 0; // index of spaces between numbers in string
		int pointer = 0; // beginning of substring
		
		sum = 0; // reset sum variable
		
		while (indxSpc < oddStr.length() - 1) {
			
			// Find spaces
			indxSpc = oddStr.indexOf(' ', indxSpc + 1);
			
			// Extract integers between spaces
			int odd = Integer.parseInt(oddStr.substring(pointer, indxSpc));
			
			// Move pointer to beginning of next number
			pointer = indxSpc + 1;
			
			// Add integers
			sum += (int)Math.pow(odd, 2);
						
		}
		
		System.out.printf("%nSum of squared odd numbers between %d and %d: %d%n", firstNum, secondNum, sum);
		
		// (f) Output all the uppercase letters
		
		i = 0; // reset counter
		
		String upperAZ = ""; // holds all uppercase characters
		
		// Cast chars to ints to determine number of iterations
		while (i <= (int)'Z' - (int)'A') {
			
			// Cast ints to chars and populate string
			upperAZ += (char)('A' + i) + " ";
			
			i++;
			
		}
		
		System.out.println("\nAll uppercase letters: " + upperAZ);
	}
}