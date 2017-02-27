package assign04;

public class SwimmingPool {
	
	// Instance variables
	
	double length; // feet
	double width; // feet
	double depth; // feet
	double fillRate; // gallons per minute
	double drainRate; // gallons per minute
	
	// Constructors
	
	// Set values of all instance variables
	
	public SwimmingPool(double ln, double wd, double dp, double fl, double dr) {
		
		length = ln;
		width = wd;
		depth = dp;
		fillRate = fl;
		drainRate = dr;
		
	}
	
	// Set the pool's dimensions only
	
	public SwimmingPool(double ln, double wd, double dp) {
		
		length = ln;
		width = wd;
		depth = dp;
		fillRate = 0;
		drainRate= 0;
	
	}
	
	// Create object but set all values to zero
	
	public SwimmingPool () {
		
		length = 0;
		width = 0;
		depth = 0;
		fillRate = 0;
		drainRate = 0;
		
	}
	
	// Set or change values of each instance variable
	
	public void setLength(double ln) {
		length = ln;
	}
	
	public void setWidth(double wd) {
		width = wd;
	}
	
	public void setDepth(double dp) {
		depth = dp;
	}
	
	public void setFill(double fl) {
		fillRate = fl;
	}
	
	public void setDrain(double dr) {
		drainRate = dr;
	}
	
	// Calculate swimming pool volume
	
	public double getVolume() {
		
		// There are 7.48 gallons per cubic foot
		double volume = length * width * depth * 7.48;
		return volume;
		
	}
	
	// Calculate amount of water needed to fill an empty or partially-filled pool
	// Volume in gallons
	
	public double waterToFill(double startVolume, double endVolume) {
		
		double waterNeeded = endVolume - startVolume;
		return waterNeeded;
		
	}
	
	// Calculate time needed to completely (or partially) fill (or drain) the pool
	
	public double timeToFill(double water) { // volume of water in gallons
		
		double timeNeeded = water / fillRate;
		return timeNeeded;
		
	}
	
	// Calculate time needed to completely or partially drain the pool
	
	public double timeToEmpty(double water) { // gallons
		
		double timeNeeded = water / drainRate;
		return timeNeeded;
		
	}
	
	// Calculate amount of water added in a specific amount of time
	
	public double amountFilledOverTime(double time) { // time in minutes
		
		double amountFilled = time * fillRate;
		return amountFilled;
		
	}
	
	// Calculate amount of water emptied in a specific amount of time
	
	public double amountEmptiedOverTime(double time) { // minutes
		
		double amountDrained = time * drainRate;
		return amountDrained;
	}

}