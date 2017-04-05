// Assignment 3
// Jim Morris

import java.util.Scanner;

public class assign03 {

	// Question 1
	
	// Repeats one or more characters n times. Also used in Question 2.
	public static void printPattern(int n, String pattern) {
		
		// Base case: stops repeating pattern when n reaches zero
		if (n > 0) {
			System.out.print(pattern);
			
			// Print pattern again, provided n > 0
			printPattern(n - 1, pattern);
		}
		
	}
	
	public static void doubleTriangle_Rec(int begin, int middle, int end) {
		
		// First triangle: base case: continue to next condition when begin < middle
		// begin = number of stars in first row, descends to narrowest (middle) row
		if (begin >= middle) {
			
			// Print begin-many stars, e.g., begin = 5 = 5 stars
			printPattern(begin, "*");
			
			// New line for next row
			System.out.println();
			
			// Print one less star on each successive call
			doubleTriangle_Rec(begin - 1, middle, end);
		}
		
		// Second triangle: base case: stop when middle > end
		// middle = narrowest row, ascends to base of second triangle (end)
		else if (middle <= end) {
			printPattern(middle, "*");
			System.out.println();
			
			// Print one more star on each successive call
			doubleTriangle_Rec(begin, middle + 1, end);		
		}
		
	}
	
	// Helper method: takes a single parameter to run recursive method
	public static void doubleTriangle(int width) {
		doubleTriangle_Rec(width, 1, width);
	}
	
	// Question 2
	
	// The following source helped me to understand the relationship between
	// row index and number of spaces:
	// http://stackoverflow.com/questions/24798173/
	// printing-diamond-pattern-in-correct-format-in-java-using-recursion
	// I wrote the method myself.
			
	public static void drawDiamond(int rowIndex, int maxStars) {
		
        // Base case: stop when row number = max number of stars * 2
		// E.g., a diamond with a max width of 4 stars will have 7 rows (4 * 2 - 1)
		if (rowIndex < maxStars * 2) {
			
			int numSpaces = 0; // reset value on each recursive call
        
	        // Number of spaces = max number of stars minus current row number
	        // Math.abs because, after largest row, the expression yields a negative value
	        // E.g, 4 - 5 = -1 = one space
	        numSpaces = Math.abs(maxStars - rowIndex);
	
	        // Number of stars = max number of stars - number of spaces
	        // E.g., in 5th row, 4 - 1 = 3
	        int numStars = maxStars - numSpaces;
	        
	        // Print pattern of spaces and star-spaces
	        printPattern(numSpaces, " ");
	        printPattern(numStars, "* ");
	        
	        System.out.println(); // new line for next row
	
	        // Recursive call: next row
	        drawDiamond(rowIndex + 1, maxStars);
	        
		}

   }
	
	// Question 3
	
	// Test if character is a vowel
	public static int isVowel (char letter, int start) {
		
		String vowels = "aAeEiIoOuU";
		
		// Base case: stop when pointer (start) passes end of string
		// Returns 0 if letter is not a vowel
		if (start == vowels.length()) {
			return 0;
		}
		
		else {
			
			// Return 1 if letter is a vowel: makes it easy to add vowels
			// in a string (see vowels method below)
			if (vowels.charAt(start) == letter) {
				return 1;
			}
			
			// Recursive call: compare letter with next vowel in string
			else {
				return isVowel(letter, start + 1);
			}
		}
	}
	
	public static int vowels (String word, int start) {
		
		// Base case: stop when pointer passes end of string
		// Returns 0 if word contains no vowels
		if (start == word.length()) {
			return 0;
		}
		
		// Recursion: run isVowel on next character in word,
		// add return value to current number of vowels
		else {
			return isVowel(word.charAt(start), 0) + vowels(word, start + 1);
		}
	}
	
	// Question 4
	
	public static int sumSquares(int num) {
		
		// Base case: stop when num equals zero
		if (num == 0) {
			return 0;
		}
		
		// Recursion: sum of squares from num down to zero
		else {
			return num * num + sumSquares(num - 1);
		}
		
	}
	
	// Question 5
	
	public static boolean isPalindrome(String str, int beg) {
		
		// Rightmost character in comparison:
		// position decreases (moves left) as beg increases (moves right)
		int end = str.length() - beg - 1;
		
		// Base case: stop when pointer (beg) passes middle of string
		if (beg > (str.length() - 1) / 2) {
			return true;
		}
		else {
			// Compare first (second, third) character in str
			// with (next to) last character
			if (str.charAt(beg) != str.charAt(end)) {
				return false;
			}
			
			// Recursion
			return isPalindrome(str, beg + 1);
		}
		
	}
	
	// Question 6
	
	// Return type long to accommodate values greater than 2^31 - 1
	public static long power(int x, int y) {
		
		// Base case: x to the power of 0 equals 1
		if (y == 0) {
			return 1;
		}
		
		// x to the power of 1 equals x
		else if (y == 1) {
			return x;
		}
		
		// Recursive call: multiply x by itself y times
		else {
			return x * power(x, y - 1);
		}
	}
	
	// Main
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Question 1
		System.out.println("1. A double right triangle 5 stars wide:\n");
		doubleTriangle(5);
		
		// Question 2
		System.out.println("\n2. A diamond 4 stars wide:\n");
		drawDiamond(1, 4);
				
		// Question 3
		System.out.print("\n3. Vowels: enter a string; any string: ");
		String howManyVowels = console.nextLine();
 		System.out.println("There are " + vowels(howManyVowels, 0)
 			+ " vowels in \"" + howManyVowels + ".\"");
		
 		// Re-instantiate console to avoid problems with nextLine()
		console = new Scanner(System.in);
 		
 		// Question 4
 		System.out.print("\n4. Calculate the sum of squares from 0 to"
 			+ " ... (enter number:) ");
 		int maxSquare = console.nextInt();
		System.out.printf("0\u00b2 + ... + %d\u00b2 = %d%n", maxSquare,
			sumSquares(maxSquare));
		
		console = new Scanner(System.in); // re-instantiate
		
		// Question 5
		System.out.print("\n5. Palindrome: enter another string: ");
		String maybePalindrome = console.nextLine();
		System.out.println("\"" + maybePalindrome + "\" "
			+ (isPalindrome(maybePalindrome, 0) ? "is" : "is not")
			+ " a palindrome.");
		
		console = new Scanner(System.in); // re-instantiate
		
		// Question 6
		System.out.print("\n6. Enter a base number and exponent, separated by spaces (x y): ");
		int baseNum = console.nextInt();
		int exponent = console.nextInt();
		System.out.printf("%d to the power of %d equals %d.", baseNum, exponent, power(baseNum, exponent));
	}
	
}