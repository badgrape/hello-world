// Assignment 2
// Jim Morris

package assign02;

public class Cylinder extends Circle {
	
	// Instance variable
	
	protected double h;
	
	// Constructors
	
	// Empty
	public Cylinder() {
		super();
		h = 0;
	}
	
	// Set values for x and y coordinates, radius, and height
	public Cylinder(int xCoordinate, int yCoordinate, double radius, double height) {
		super(xCoordinate, yCoordinate, radius);
		setHeight(height);
	}
	
	// Create cylinder with values from existing circle
	public Cylinder(Circle circle, double height) {
		super(circle.x, circle.y, circle.r);
		setHeight(height);
	}
	
	// toString override
	
	public String toString() {
		return super.toString() + " ; h = " + h + "cm";
	}
	
	// Set height
	
	public void setHeight(double height) {
		h = height;
	}
	
	// Set radius and center of base: inherit from Circle
	
	// Return radius and center of base: inherit from Circle

	// Calculate volume
	
	public double getVolume() {
		return getArea() * h;
	}
	
	// Calculate surface area
	
	public double getSurfaceArea() {
		return (2 * getArea()) + (getCircumference() * h);
	}
	
	// Print cylinder
	
	public void printCylinder() {
		System.out.println("Cylinder: " + toString());
	}
	
	// Print volume
	
	public void printVolume() {
		System.out.printf("Volume: %.2fcm\u00b3%n", getVolume());
	}
	
	// Print surface area
	
	public void printSurfaceArea() {
		System.out.printf("Surface area: %.2fcm\u00b2%n", getSurfaceArea());
	}
		
}
