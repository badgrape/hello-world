import java.util.Scanner;

public class ch4_ex10 {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Determine operation
		System.out.print("What kind of operation would you like to perform? (+ - * /) ");
		String op = console.next();
		
		String term1 = null; // first number in equation
		String term2 = null; // second number in equation
		String term3 = null; // answer
		
		boolean valid = true; // to test input
		
		// Print proper terminology for each kind of equation
		switch (op) {
		case "+":
			term1 = "augend";
			term2 = "addend";
			term3 = "sum";
			break;
		case "-":
			term1 = "minuend";
			term2 = "subtrahend";
			term3 = "difference";
			break;
		case "*":
			term1 = "multiplicand";
			term2 = "multiplier";
			term3 = "product";
			break;
		case "/":
			term1 = "dividend";
			term2 = "divisor";
			term3 = "quotient";
			break;
		default: valid = false; // user does not enter an arithmetic operator
		}
		
		if (!valid) {
			System.out.println("Error: enter an arithmetic operator and run the program again.");
		}
		
		else {
		
			// Input numbers
			System.out.print("Enter the " + term1 + ": ");
			double num1 = console.nextDouble();
			
			System.out.print("Enter the " + term2 + ": ");
			double num2 = console.nextDouble();
			
			double result = 0; // answer
			
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
				if (num2 != 0) {
					result = num1 / num2;
				}
				// Throw error if denominator is zero
				else {
					System.out.println("You can't divide by zero. Run the program again.");
					valid = false; // to stop program
				}
				break;
			}
			
			// Print answer
			if (valid) {
				System.out.println("Calculating the " + term3 + " ...");
				System.out.printf("%.2f %s %.2f = %.2f", num1, op, num2, result);
			}
		
		}
		
	}
	
}