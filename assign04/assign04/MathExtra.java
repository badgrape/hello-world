package assign04;

public class MathExtra {
	
	// Calculate greatest common divisor
	
	// Nicolas: your gcd method is definitely more elegant,
	// but I had difficulty following the recursion,
	// so I did the math myself and this is what I came up with:
	
	public static int gcd (int x, int y) {
		
		// Basically, divide the divisor by the remainder
		// until the divisor equals zero
		
		while (y != 0) {
				
			// Remainder of x / y
			int z = x % y;
				
			// Divisor becomes dividend
			x = y;
				
			// Remainder becomes divisor,
			// so zero remainder causes loop condition to fail
			y = z;
				
		}
		
		return x + y;
		
	}
	
}