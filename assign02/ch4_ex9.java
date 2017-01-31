import java.util.Scanner;

public class ch4_ex9 {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Determine operation and input numbers
		System.out.print("What kind of operation would you like to perform? (+ - * /) ");
		String op = console.next();
		
		System.out.print("Enter the first number: ");
		int num1 = console.nextInt();
		
		System.out.print("Enter the second number: ");
		int num2 = console.nextInt();
		
		int result = 0; // answer
		int divrm = 0; // division remainder
		
		boolean valid = true; // to test if user enters an arithmetic operator
		
		// Calculate the answer
		switch (op) {
		
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			if (num2 !=0) {
				result = num1 / num2;
				divrm = num1 % num2; // calculate remainder
			}
			// Error message if denominator is zero
			else {
				System.out.println("You can't divide a number by zero. Run the program again.");
			}
			break;
		default: valid = false; // user does not enter an arithmetic operator
		}
		
		// Print answer
		if (valid) {
			System.out.printf("%d %s %d = %d", num1, op, num2, result);
			if (op.equals("/") && divrm != 0) System.out.printf(" R %d", divrm); // print remainder
		}
		else {
			System.out.println("Invalid entry. Run the program again.");
		}
		
	}
	
}