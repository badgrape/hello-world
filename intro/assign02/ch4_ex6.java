// Chapter 4, exercise 6
// Jim Morris

import java.util.Scanner;

public class ch4_ex6 {
	
	static Scanner console = new Scanner(System.in);
	static final double epsilon = 0.01d; // tolerance: ensures accuracy to hundredth decimal place
	
	public static void main(String[] args) {
		
		System.out.println("Please enter the triangle's ...");
		
		// Input triangle's dimensions
		System.out.print("(a) base: ");
		double bs = console.nextDouble();
		
		System.out.print("(b) height: ");
		double hgt = console.nextDouble();
				
		System.out.print("(c) hypoteneuse: ");
		double hyp = console.nextDouble();
		
		// Square the value of each side
		double bs2 = Math.pow(bs, 2);
		double hgt2 = Math.pow(hgt, 2);
		double hyp2 = Math.pow(hyp, 2);
				
		System.out.println("\nAccording to the Pythagorean Theorem, a\u00b2 + b\u00b2 = c\u00b2");

		String ans;
		
		// (a2 + b2) = c2 if the absolute value of their difference is less than 0.01
		if (Math.abs((bs2 + hgt2) - hyp2) < epsilon) {
			ans = "IS";
			}
		else {
			ans = "IS NOT";
			}
				
		System.out.println ("Therefore, your triangle " + ans + " a right angle."
			+ (ans == "IS NOT" ? "\n(Disagree? Try entering more-precise decimal values.)" : ""));
	}
	
}