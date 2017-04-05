// Chapter 3, exercise 4
// Jim Morris

import java.util.*;

public class ch3_ex4 {
	
static Scanner console = new Scanner(System.in);

	public static void main(String[] args) {
	
			double cost;
			double area;
			double bagSize;

			System.out.print("Enter the amount of fertilizer, in pounds, in one bag: ");
			bagSize = console.nextDouble();

			System.out.println();
			System.out.print("Enter the cost of the " + bagSize + " pound fertilizer bag: ");
			cost = console.nextDouble();

			System.out.println();
			System.out.print("Enter the area, in square feet, that can be fertilized by one bag: ");
			area = console.nextDouble();

			System.out.println();
			
			// Error corrected: cost should be dividend and bagSize should be divisor
			System.out.printf("The cost of the fertilizer per pound is: $%.2f%n", cost / bagSize);
			
			// Error corrected: cost is dividend and area is divisor
			System.out.printf("The cost of fertilizing per square foot is: $%.4f%n", cost / area);
	}
}