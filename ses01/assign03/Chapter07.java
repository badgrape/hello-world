// Chapter 7 exercises
// Jim Morris

package assign03;

import java.util.Scanner;

public class Chapter07 {
	
	public static Scanner console = new Scanner(System.in);
	
	// Exercise 1
	
	public static boolean isVowel (char ch) {
		
		String vowels = "aAeEiIoOuU";
		
		int position = vowels.indexOf(ch);
		
		// Test if ch appears in the string of vowels
		if (position < 0) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public static void exerciseOneUI() {
		
		System.out.print("Enter a character: ");
		char character = console.next().charAt(0);
		
		System.out.println(character + " is " + (isVowel(character) ? "" : "not ") + "a vowel.");
	}
	
	// Exercise 2
	
	public static int countVowels (String str) {
		
		int numVowels = 0;
		
		for (int i = 0; i < str.length(); i++) {
			
			// For each character i in str, test if it's a vowel
			// If yes, then add one to the vowel count
			if (isVowel(str.charAt(i))) {
				numVowels++;
			}
			
		}
		return numVowels;
		
	}
	
	public static void exerciseTwoUI() {
		
		System.out.print("Enter a word: ");
		String word = console.next();
		
		int vowels = countVowels(word);
		
		System.out.println("There are " + vowels + " vowels in " + word + ".");
		
	}
	
	// Exercise 6
	
	public static int reverseDigit(int integer) {
		
		// Convert int to string
		String integerStr = String.valueOf(integer);
		
		char number; // individual numbers in string
		String reverseStr = ""; // number string in reverse order
		boolean negative = false; // to retain negative operator
		
		// Loop begins on last character of string and works backwards
		for (int i = integerStr.length() - 1; i >= 0; i--) {
			
			// Captures character and adds to new string in reverse order
			number = integerStr.charAt(i);
			
			// Add character to new string in reverse order
			// Discard '-' character but note if original number is negative
			if (number != '-') {
				reverseStr += number;
			}
			else {
				negative = true;
			}
		}
		
		// Convert string to int
		integer = Integer.parseInt(reverseStr);
		
		// Apply negative operator if appropriate
		if (negative) {
			integer = -integer;
		}
		
		return integer;
		
	}
	
	public static void exerciseSixUI() {
		
		System.out.print("Enter an integer: ");
		int integer = console.nextInt();
		
		System.out.println("Digits reversed: " + reverseDigit(integer));
		
	}
	
	// Exercise 11
	
	public static boolean isPalindrome(int number) {
		
		int toReverse = number; // working copy of number to reverse
		int reversed = 0;
		
		while (toReverse > 0)
		{
			// Isolate last digit, e.g., 532 % 10 = 2
			int digit = toReverse % 10;
			 
			// Build reverse number
			// Put last digit in first position, second-last digit in second position, etc.
			// Multiplying by 10 moves existing number(s) up one order of magnitude
			// Next number added in the lowest place, e.g., 2 * 10 + 3 = 23
			reversed = reversed * 10 + digit;
			 
			// Save digits remaining from original number, e.g., 53 / 10 = 5
			toReverse = toReverse / 10;
		 }
		
		if (reversed == number) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void exerciseElevenUI() {
		
		System.out.print("Enter a non-negative integer: ");
		int number = console.nextInt();
		
		// Tests for non-negative, not positive, integers because zero is also a palindrome
		while (number < 0) {
			System.out.print("Please enter a NON-negative integer: ");
			number = console.nextInt();
		}
		
		System.out.println(number + " is " + (isPalindrome(number) ? "" : "not ") + "a palindrome.");
		
	}
	
	// Exercise 12
	
	public static boolean isPrime(int number) {
		
		int divisor = 2; // a composite (non-prime) number is divisible by two or more
		boolean prime = true;
		
		// A composite number is divisible by a number between 2 and 10
		while (divisor <= 10 && prime) {
			
			if (number % divisor == 0) {
				prime = false;
			}
			
			divisor++;
		}
		
		return prime;
	}
	
	// Exercise 13
	
	public static void exerciseThirteenUI() {
		
		System.out.println("Enter a positive integer: ");
		int number = console.nextInt();
		
		// Validate input: ensure integer is positive and could be prime
		while (number <= 1) {
			
			if (number < 1) {
				System.out.println("Please enter a POSITIVE integer: ");
			}
			else if (number == 1) {
				System.out.println(number + " is neither prime nor composite. Enter another number: ");
			}
			
			number = console.nextInt();
		}
		
		// Check if number is prime
		if (isPrime(number)) {
			
			System.out.print(number + " is prime");
			
			// Check if prime number is also a palindrome
			if (isPalindrome(number)) {
				System.out.print(" and a palindrome!\n");
			}
			else {
				System.out.print(" but not a palindrome.\n");
			}
		}
		
		else {
			System.out.println(number + " is not prime");
		}
		
	}
		
}