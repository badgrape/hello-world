import java.util.Scanner;

public class ch4_ex9 {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("What kind of operation would you like to perform? (+ - * /) ");
		String op = console.next();
		
		System.out.print("Enter the first number: ");
		int num1 = console.nextInt();
		
		System.out.print("Enter the second number: ");
		int num2 = console.nextInt();
		
		int result = 0;
		int divrm = 0;
		
		boolean valid = true;
		
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
				divrm = num1 % num2;
			}
			else {
				System.out.println("You can't divide a number by zero. Run the program again.");
			}
			break;
		default: valid = false;
		}
						
		if (valid == true) {
			System.out.printf(num1 + op + num2 + " = " + result
				+ (op.equals("/") && divrm != 0 ? " R" + divrm : ""));
		}
		else {
			System.out.println("Invalid entry. Run the program again.");
		}
		
	}
	
}