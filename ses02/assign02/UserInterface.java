// Assignment 2
// Jim Morris

package assign02;

import java.util.Scanner;

public class UserInterface {

	public static Scanner console = new Scanner(System.in);
	
	// Test program
	public static void main(String[] args) {
		
		// Initialize object variables
		int xCrd = 0;
		int yCrd = 0;
		double rad = 0.0d;
		double hgt = 0.0d;
		
		// Initialize objects
		Point thisPoint = null;
		Circle thisCircle = null;
		Cylinder thisCylinder = null;
		
		int choice = 0; // menu selector
		char build = 0; // option to build next object based on previous
		char restart = 0; // option to restart program
				
		do {
			
			build = 'n'; // (re)set build-on option
			
			// A very simple menu
			System.out.print("Options for an operation:\n" +
				" (1) Plot a point\n" +
				" (2) Trace a circle\n" +
				" (3) Set up a cylinder\n" +
				" (4) Exit this exercise\n" +
				"What will you make? ");
			choice = console.nextInt();
			
			if (choice > 0 && choice < 4) {
				
				// Enter point data
				System.out.print("X-coordinate: ");
				xCrd = console.nextInt();
				System.out.print("Y-coordinate: ");
				yCrd = console.nextInt();
				
				// Construct point object
				if (choice == 1) {
					
					thisPoint = new Point(xCrd, yCrd);
					
					// Print point data
					thisPoint.printPoint();
					
					// Prompt next step
					System.out.print("Draw a circle around this point? (y/n) ");
					build = console.next().toLowerCase().charAt(0);
					
				}
				
			}
			
			// If building circle/cylinder from scratch
			// or making circle from existing point
			if (choice > 1 && choice < 4 || build == 'y') {
				
				// Enter radius
				System.out.print("Radius: ");
				rad = console.nextDouble();
				
				if (choice == 2 || build == 'y') {
					
					if (choice == 2) {
						// Construct circle from scratch
						thisCircle = new Circle(xCrd, yCrd, rad);
					}
					else if (build == 'y') {
						// Construct with existing point
						thisCircle = new Circle(thisPoint, rad);
					}
					
					// Print circle data
					thisCircle.printCircle();
					thisCircle.printArea();
					thisCircle.printCircumference();
					
					// Prompt next step
					System.out.print("Construct a cylinder from this circle? (y/n) ");
					build = console.next().toLowerCase().charAt(0);

				}
				 
			}
			
			// If building cylinder from scratch
			// or making cylinder from existing circle
			if (choice == 3 || build == 'y') {
				
				// Enter cylinder data
				System.out.print("Height: ");
				hgt = console.nextDouble();
				
				if (choice == 3) {
					// Construct cylinder from scratch
					thisCylinder = new Cylinder(xCrd, yCrd, rad, hgt);
				}
				
				else if (build == 'y') {
					// Construct cylinder from existing circle
					thisCylinder = new Cylinder(thisCircle, hgt);
				}
				
				// Print cylinder data
				thisCylinder.printCylinder();
				thisCylinder.printVolume();
				thisCylinder.printSurfaceArea();					
				
			}
			
			// Prompt restart
			if (choice > 0 && choice < 4) {
				System.out.print("Build another object? (y/n) ");
				restart = console.next().toLowerCase().charAt(0);
			}
			
			System.out.println();
			
		}
		
		while (choice > 0 && choice < 4 && restart == 'y');
		
		// Exit message
		System.out.println("Thanks for playing :)");

	}
	
}
