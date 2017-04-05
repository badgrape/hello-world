// Assignment 2
// Jim Morris

package assign02;

public class Circle extends Point {

	// Instance variable
	
	protected double r;
	
	// Constructors
	
	// Empty
	public Circle() {
		super();
		r = 0;
	}
	
	// Set values for x and y coordinates, and radius
	public Circle(int xCoordinate, int yCoordinate, double radius) {
		super(xCoordinate, yCoordinate);
		setRadius(radius);
	}
	
	// Create circle using values from existing point
	public Circle(Point point, double radius) {
		super(point.x, point.y);
		setRadius(radius);
	}
	
	// toString override
	
	public String toString() {
		return super.toString() + " ; r = " + r + "cm";
	}
	
	// Set center
	
	public void setCenter (int xCoordinate, int yCoordinate) {
		setX(xCoordinate);
		setY(yCoordinate);
	}	
	
	// Set radius
	
	public void setRadius(double radius) {
		r = radius;
	}
	
	// Return center
	
	public String getCenter() {
		return x + ", " + y;
	}
	
	// Return radius
	
	public double getRadius() {
		return r;
	}
		
	// Calculate area
	
	public double getArea() {
		return Math.PI * r * r;
	}
		
	// Calculate circumference
	
	public double getCircumference() {
		return Math.PI * r * 2;
	}
	
	// Print circle
	
	public void printCircle() {
		System.out.println("Circle: " + toString());
	}
	
	// Print center
	
	public void printCenter() {
		System.out.println("Center: " + getCenter());
	}
	
	// Print radius
	
	public void printRadius() {
		System.out.println("Radius: " + r + "cm");
	}
	
	// Print area
	
	public void printArea() {
		System.out.printf("Area: %.2fcm\u00b2%n", getArea());
	}
	
	// Print circumference
	
	public void printCircumference() {
		System.out.printf("Circumference: %.2fcm%n", getCircumference());
	}

}
