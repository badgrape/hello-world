// Part 2
// Jim Morris

package assign03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Part02 {
	
	public static Scanner console = new Scanner(System.in);
	
	// (a) Guess that number method
	
	public static void guessTheNumber() throws FileNotFoundException {
		
		Scanner infile = new Scanner(new FileReader("correctGuess"));
		
		// Read from the file
		int correctNumber = infile.nextInt(); // number contained in the file
		
		infile.close();
		
		System.out.print("Guess a number: ");
		
		int guessedNumber = console.nextInt();
		
		boolean correct = true; // starts true because loop runs only if first guess is wrong
		
		// Evaluate first guess and run block if incorrect
		if (correctNumber != guessedNumber) {
			
			correct = false;
			
			int i = 0;
			
			// Loop allows four guesses because first guess was already submitted
			while (i < 4 && !correct) {
				
				// Tell user if guess is greater or less than the answer
				System.out.print("The number is "
					+ (correctNumber > guessedNumber ? "greater" : "less")
					+ " than " + guessedNumber + ". Try again: ");
				
				guessedNumber = console.nextInt();

				// Loop terminated if next guess is correct
				if (correctNumber == guessedNumber) {
					correct = true;
				}
				
				i++;
				
			}
				
		}
		
		// Evaluate (correct) first guess when loop does not run,
		// or final guess when loop terminates
		if (correct) {
			System.out.println("Correct! :)");
		}
		else {
			System.out.println("Sorry :(");
		}

	}
	
	// (b) Average digits method
	
	public static void averageDigits() {
		
		// Input
		
		System.out.print("Please enter a five-digit number: ");
		int number = console.nextInt();
		
		// Five-digit number divided by 10,000 yields a quotient greater than 1 and less than 10
		// This test also rejects negative and five-zero entries
		while (number / 10000 < 1 || number / 10000 >= 10) {
			System.out.print("Your input is invalid. Please enter a five-digit number: ");
			number = console.nextInt();
		}
		
		// Output
		
		int numberSplit = number; // Working copy of number as it gets separated into digits
		int sum = 0;
		
		while (numberSplit > 0) {
			
			// Isolate final digit
			int digit = numberSplit % 10;
			
			// Add digit(s)
			sum += digit;
			
			// Remove digit(s) already added to sum; remaining digits re-looped
			numberSplit = numberSplit / 10;
		}
		
		// Convert sum to decimal value
		double decimalSum = (double) sum;
		
		System.out.printf("The average of the digits in %d is %.1f%n", number, decimalSum / 5);
	}
	
	// (c) Convert phone letters to digits
	
	public static int convertLetterToDigit(char letter) {
		
		// Convert letter to upper case to simplify switch conditions
		letter = Character.toUpperCase(letter);
		
		int digit = 0; // stores number converted from letter
		
		// Conditions correspond to letter-number groupings on phone keypad
		switch (letter) {
			case 'A': case 'B': case 'C':
				digit = 2;
				break;
			case 'D': case 'E': case 'F':
				digit = 3;
				break;
			case 'G': case 'H': case 'I':
				digit = 4;
				break;
			case 'J': case 'K': case 'L':
				digit = 5;
				break;
			case 'M': case 'N': case 'O':
				digit = 6;
				break;
			case 'P': case 'Q': case 'R': case 'S':
				digit = 7;
				break;
			case 'T': case 'U': case 'V':
				digit = 8;
				break;
			case 'W': case 'X': case 'Y': case 'Z':
				digit = 9;
				break;
				
		}
		
		return digit;
	}
	
	public static void requestPhoneNumber() {
		
		// Read entire string, including spaces
		console = console.useDelimiter("\n");
		
		System.out.print("Enter a phone number: ");
		String alphaPhoneNumber = console.nextLine(); // alphanumeric phone number
		
		
		String symbols = "()- "; // Special symbols to ignore
		
		String digitPhoneNumber = ""; // numeric phone number
		
		for (int i = 0; i < alphaPhoneNumber.length(); i++) {
			
			char character = alphaPhoneNumber.charAt(i);
			
			// Check if character is one of the ignored symbols
			// If so, add to numeric phone number string
			
			for (int j = 0; j < symbols.length(); j++) {
				
				if (character == symbols.charAt(j)) {
					digitPhoneNumber += character;
				}
		
			}
			
			// "if" conditions ensure that symbols other than '(', ')', '-' and space
			// are omitted from converted string 
			
			if (Character.isDigit(character)) {
				
				// Add digits from user input to converted string
				digitPhoneNumber += character;
				
			}
			
			if (Character.isLetter(character)) {
				
				int digit = convertLetterToDigit(character);
			
				// Add converted number in place of its corresponding letter
				digitPhoneNumber += digit;
			
			}
		
		}
		
		// Output
		System.out.println(digitPhoneNumber);
	}
	
}