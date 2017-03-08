package assign04;

import java.util.Scanner;

public class FractionUI {
	
	public static Scanner console = new Scanner(System.in);
	
	// Prompt user to re-enter denominator if previous attempt = 0
	
	public static void inputValidation (Fraction frac) {

		// While denominator = 0, enter another denominator
		while (!frac.valid()) {
			System.out.print("Enter a non-zero denominator: ");
			frac.setDenominator(console.nextInt());
		}
		
	}
	
	public static void main(String[] args) {
	
		System.out.println("Please enter two fractions. " +
			"Separate the numerators and denominators with spaces (x y).\n");
		
		System.out.print("Fraction 1 (a b): ");
		int a = console.nextInt();
		int b = console.nextInt();
		
		// Create first Fraction object and validate
		Fraction frac1 = new Fraction(a, b);
		inputValidation(frac1);

		System.out.print("Fraction 2 (c d): ");
		int c = console.nextInt();
		int d = console.nextInt();
		
		// Create second Fraction object and validate
		Fraction frac2 = new Fraction(c, d);
		inputValidation(frac2);
		
		// Apply arithmetic methods
		Fraction sum = Fraction.add(frac1, frac2);
		Fraction diff = Fraction.subtract(frac1, frac2);
		Fraction prod = Fraction.multiply(frac1, frac2);
		Fraction quot = Fraction.divide(frac1, frac2);
		
		// Print results
		System.out.printf("%n%s + %s = %s = %.2f%n", frac1, frac2, sum, sum.toDouble());
		System.out.printf("%s - %s = %s = %.2f%n", frac1, frac2, diff, diff.toDouble());
		System.out.printf("%s * %s = %s = %.2f%n", frac1, frac2, prod, prod.toDouble());
		
		// Validate and return "Error" if divisor = 0
		System.out.printf("(%s) / (%s) = %s = %.2f%n", frac1, frac2,
			(quot.valid() ? quot : "Error"), quot.toDouble());
	}
	
}