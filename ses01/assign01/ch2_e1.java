// Chapter 1, exercise 1
// Jim Morris

public class ch2_e1 {

	public static void main(String[] args) {
		
		String[] text = {
				"Programming Assignment 1",
				"Introduction to Java",
				"Author: Jim Morris",
				"Due date: January 18, 2016"
		};
		
		System.out.println("**********************************"); // 34 columns
		
		for (int i = 0; i < text.length; i++) {
			System.out.printf("%-1s %-30s %1s %n", "*", text[i], "*");
		}
		
		System.out.println("**********************************");

	}
	
}