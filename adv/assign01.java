// Advanced Java Programming
// Assignment 1
// Jim Morris

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class assign01 {

	// Question 1
	
	public static void setGetAlpha() {
		
		double[] alpha = new double[50];
		
		for (int i = 0; i < alpha.length; i++) {
			
			// First 25 elements equal square of index
			if (i < 25) {
				alpha[i] = i * i;
			}
			
			// Last 25 elements equal index * 4
			else {
				alpha[i] = i * 4;
			}
			
			// Print array values
			System.out.printf("%8.2f", alpha[i]);
			
			// Insert newline after every 10th entry
			if ((i + 1) % 10 == 0) {
				System.out.print("\n");
			}
			
		}
				
	}
	
	// Question 2
		
	public static int smallestIndex(int[] arrayOfInts) {
		
		// Set with largest possible int value; works with any int[] array
		int smallestInteger = Integer.MAX_VALUE;
		int smallestIndex = 0;
				
		for (int i = 0; i < arrayOfInts.length; i++) {
			
			// Compares current smallestInteger against next value in array
			// If less, reassign smallestInteger and save index
			if (arrayOfInts[i] < smallestInteger) {
				smallestInteger = arrayOfInts[i];
				smallestIndex = i;
			}
					
		}
				
		return smallestIndex;
				
	}
	
	// Test method
	public static void testSmallestIndex() {
		
		int[] randomArray = new int[10];
		
		for (int i = 0; i < randomArray.length; i++) {
			// Create array of 10 random integers between 0 and 99
			randomArray[i] = (int) (Math.random() * 100);
			
			// Print the array
			System.out.println(i + " : " + randomArray[i]);
		}
		
		// Run smallestIndex; display output
		System.out.println("The smallest number is at position " + smallestIndex(randomArray));
		
	}
	
	// Question 3
	// The five methods correspond to five distinct tasks
	
	// Create a file with random grades for a random number students,
	// since teachers have very little control over their class sizes
	// and the quality of their students' work :P
	// Argument designates filename
	public static void randomGrades(String fileName) throws FileNotFoundException {
		
		// Random class size
		// Math.random returns a positive double value >= 0.0 and < 1.0
		// So +1 ensures at least one student
		int numberOfValues = (int) (Math.random() * 100 + 1);
		
		PrintWriter outFile = new PrintWriter(fileName);
		
		for (int i = 0; i < numberOfValues; i++) {
			// Random grades between 0.0 and 99.9
			double nextValue = Math.random() * 100;
			
			// Save grades to one decimal place
			outFile.printf("%.1f%n", nextValue);
		}
		
		outFile.close();
						
	}
	
	// Count the number of grades in the file
	// Takes filename as argument
	public static int countGrades (String fileName) throws FileNotFoundException {
		
		Scanner inFile = new Scanner(new FileReader(fileName));
		
		int count = 0;
		
		
		while (inFile.hasNextDouble()) {
			// Add one to the counter for every value in the file
			count ++;
			
			// Move pointer to the next value
			inFile.nextDouble();
		}
		
		inFile.close();
		
		System.out.println("Number of grades submitted: " + count);
		
		// Return number of grades
		return count;
	}
	
	// Save grades in an array
	// Takes filename as argument
	public static double[] getGrades(String fileName) throws FileNotFoundException {
		
		// Get number of grades in file; used to determine array size
		int count = countGrades(fileName);
		
		double[] grade = new double[count];
		
		Scanner inFile = new Scanner(new FileReader("grades"));
		
		for (int i = 0; i < count; i++) {
			// Populate array with values from file
			grade[i] = inFile.nextDouble();
		}
		
		inFile.close();
		
		// Return array
		return grade;
		
	}
	
	// Test if value falls within certain range
	// Arguments: upper and lower limits of range, and value to test
	public static boolean inRange(double low, double high, double test) {
		
		// Use tolerance to test equivalence of floating-point values
		if ((test > low || Math.abs(test - low) < 0.000001) &&
			(test < high || Math.abs(test - high) < 0.000001)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	// Determine where grades fall within the different ranges
	// Takes grade array as argument
	public static void getRanges(double[] grade) {
		
		// Array of ranges with "implicit" rounding
		// Working with floating point-values throughout instead of rounding to int
		// Sub-arrays: first two values define range;
		// third value used to store how many grades fall within that range
		double[][] range = {
			{0.0d, 24.4d, 0.0d},
			{24.5d, 49.4d, 0.0d},
			{49.5d, 74.4d, 0.0d},
			{74.5d, 100.0d, 0.0d}
		};
		
		int i;
		
		for (i = 0; i < grade.length; i++) {
			
			for (int j = 0; j < range.length; j++) {
				
				// inRange method: if grade falls within range, add to count
				if (inRange(range[j][0], range[j][1], grade[i])){
					range[j][2]++;
				}
				
			}
			
		}
		
		for (i = 0; i < range.length; i++) {
			// Print ranges and final count of values within each
			System.out.printf("%.0f-%.0f: %.0f%n", range[i][0], range[i][1], range[i][2]);
		}
				
	}
	
	// Question 4
	
	public static Scanner console = new Scanner(System.in);
	
	// Method with two 1-D arrays: one for student names, the other for grades
	// Array indices are common "key" between them
	public static void getStudentInfo() {
		
		int classSize = 0;
		
		// Determine size of arrays; insist on maximum 50 students
		do {
			System.out.print("How many students in your class? (50 max.) ");
			
			if (console.hasNextInt()) {
				classSize = console.nextInt();
			}
		}
		while (classSize <= 0 || classSize > 50);
		
		// Initialize name and grade arrays
		String[] student = new String[classSize];
		float[] score = new float[classSize];
		
		float sum = 0.0f; // sum of grades; use to compute average
		
		int i; // counter
		
		for (i = 0; i < classSize; i++) {
			
			System.out.print("Enter student's first name and test score, separated by a space: ");
			
			student[i] = console.next();
			
			// Round scores to one decimal place
			score[i] = Math.round(console.nextFloat() * 10) / 10.0f;
			
			System.out.println(student[i] + ": " + score[i]);
			
			// Add scores
			sum += score[i];
			
		}
		
		// Compute average and round to one decimal place
		float average = Math.round((sum / classSize) * 10) / 10.0f;
		
		System.out.println("Class average: " + average);
		
		// Determine highest grade starting with lowest possible float value
		float highScore = Float.MIN_VALUE;
		
		System.out.println("Student(s) below class average:");
		
		for (i = 0; i < classSize; i++) {
			
			// Output students whose grades fall below average
			if (score[i] < average) {
				System.out.println("* " + student[i]);
			}
			
			// If current score is greater than previous high score, save new high score
			if (score[i] > highScore) {
				highScore = score[i];
			}
			
		}
		
		System.out.println("Highest test score: " + highScore);
		System.out.println("High score achieved by: ");
		
		// Find student(s) who earned the highest mark
		for (i = 0; i < classSize; i++) {
			
			// Iterate through grade array, find grades matching highest score
			// Necessary because multiple students could earn the same grade
			// Output all students who received the highest mark
			if (Math.abs(score[i] - highScore) < 0.000001) {
				System.out.println("* " + student[i]);
			}
			
		}
						
	}
	
	// Question 5
	
	public static void rollDice() {
		
		// 2-D array to hold random dice values
		int[][] dice = new int[1000][2];
		
		// Another 2-D array to check for different sums (first sub-member)
		// and record the number of pairs with each sum (second sub-member)
		int[][] pairSum = {
			{2, 0}, {3, 0}, {4, 0}, {5, 0},
			{6, 0}, {7, 0}, {8, 0}, {9, 0},
			{10, 0}, {11, 0}, {12, 0}
		};
		
		int i; // primary counter
		
		for (i = 0; i < dice.length; i++) {
			
			int j; // secondary counter
			
			int sum = 0;
			
			// Populate array of dice throws
			for (j = 0; j < dice[i].length; j++) {
				
				// Math.random() * 6 generates values between 0 and 5, hence +1
				dice[i][j] = (int) (Math.random() * 6) + 1;				
				
				// Calculate sum of both dice
				sum += dice[i][j];
				
			}
			
			for (j = 0; j < pairSum.length; j++) {
				
				// Count pairs equaling each sum
				// If sum matches first sub-member, increment second sub-member
				if (sum == pairSum[j][0]) {
					pairSum[j][1]++;
				}
				
			}
						
		}
		
		// Print number of pairs that equal each sum
		for (i = 0 ; i < pairSum.length; i++) {
			System.out.println("Dice w/ sum " + pairSum[i][0] + ": "
				+ pairSum[i][1]);
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String goAgain; // used in loop condition
		
		do {
			
			// A very simple menu
			System.out.print("Welcome to Advanced Java Assignment 1\n"
				+ "(1) View an array whose elements equal either index\u00b2 or 4(index).\n"
				+ "(2) Get the index of the smallest integer in an array.\n"
				+ "(3) Read a file of student test scores and categorize them in ranges.\n"
				+ "(4) Manually enter student names and grades, and get info about averages and high achievers.\n"
				+ "(5) Roll 1000 dice and classify the sums.\n"
				+ "What would you like to do? ");
			
			// Use string values to avoid input mismatch exception
			String selection = console.next();
			
			System.out.println();
			
			// Switch compares strings as if it were using the String.equals method
			// docs.oracle.com/javase/8/docs/technotes/guides/language/strings-switch.html
			switch (selection) {
			
			case "1":
				// Question 1
				setGetAlpha();
				break;
			case "2":
				// Question 2
				testSmallestIndex();
				break;
			case "3":
				// Question 3
				randomGrades("grades");
				double[] grades = getGrades("grades");
				getRanges(grades);
				break;
			case "4":
				// Question 4
				getStudentInfo();
				break;
			case "5":
				// Question 5
				rollDice();
				break;
			default:
				System.err.println("Invalid option.");
			}
			
			System.out.println();
			
			System.out.print("Do something else? (y/n) ");
			goAgain = console.next();
			
			System.out.println();
						
		}
		
		// Again, very simple: anything other than "y" stops program
		while (goAgain.equals("y"));
		
		System.out.println("See you around :)");
		
	}
	
}
