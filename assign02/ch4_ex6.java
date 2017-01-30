// Chapter 4, exercise 6
// Jim Morris

import java.util.Scanner;

public class ch4_ex6 {
	
	static Scanner console = new Scanner(System.in);
	static final double epsilon = 0.01d;
	
	public static void main(String[] args) {
		
		System.out.println("Please enter the triangle's ...");
		
		System.out.print("(a) base: ");
		double bs = console.nextDouble();
		
		System.out.print("(b) height: ");
		double hgt = console.nextDouble();
				
		System.out.print("(c) hypoteneuse: ");
		double hyp = console.nextDouble();
				
		double bs2 = Math.pow(bs, 2);
		double hgt2 = Math.pow(hgt, 2);
		double hyp2 = Math.pow(hyp, 2);
		
		//System.out.println("\nAbsolute value of the difference: " + Math.abs((bs2 + hgt2) - hyp2));
		
		System.out.println("\nAccording to the Pythagorean Theorem, a\u00b2 + b\u00b2 = c\u00b2");

		String ans;
		
		//if (bs2 + hgt2 == hyp2) {ans = "IS";}
		if (Math.abs((bs2 + hgt2) - hyp2) < epsilon) {ans = "IS";}
		else {ans = "IS NOT";}
				
		System.out.println ("Therefore, your triangle " + ans + " a right angle."
			+ (ans == "IS NOT" ? "\n(Try entering decimal values with greater precision." : ""));
	}
	
}