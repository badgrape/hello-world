// Assignment 2
// Jim Morris

package assign02;

public class Point {
	
	// Instance variables
	
	protected int x, y;
	
	// Constructors
	
	// Empty
	public Point() {
		x = 0;
		y = 0;
	}
	
	// Set values for x and y coordinates
	public Point(int xCoordinate, int yCoordinate) {
		setX(xCoordinate);
		setY(yCoordinate);
	}
	
	// Show point: toString override
	
	public String toString() {
		return "x, y = " + x + ", " + y;
	}
	
	// Set coordinates of point
	
	public void setX(int xCoordinate) {
		x = xCoordinate;
	}
	
	public void setY(int yCoordinate) {
		y = yCoordinate;
	}

	// Return coordinates
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	// Print point
	
	public void printPoint() {
		System.out.println("Point: " + toString());
	}
	
	// Print coordinates
	
	public void printX() {
		System.out.println("x: " + x);
	}
	
	public void printY() {
		System.out.println("y: " + y);
	}
	
}
