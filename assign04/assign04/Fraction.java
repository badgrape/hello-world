package assign04;

public class Fraction {
	
	// Instance variables
	
	private int numerator;
	private int denominator;
	
	// Constructor
	
	public Fraction(int num, int den) {
		
		numerator = num;
		denominator = den;
		
		if (valid()) {
			simplify();
		}
		
	}
	
	// (Re)set instance variables
	
	public void setNumerator(int num) {
		
		numerator = num;
		
		if (valid()) {
			simplify();
		}	
		
	}
	
	public void setDenominator (int den) {
	
		denominator = den;
		
		if (valid()) {
			simplify();
		}
		
	}
	
	// Check that fraction is rational
	
	// I made input validation into a separate method
	// in order to check for a zero-value denominator
	// before running simplify(). If simplify() runs with
	// denominator = 0, then the numerator is reduced to 1
	// regardless of its initial value.
	// The valid() method can also be implemented in various ways
	// in the user interface.
	
	public boolean valid() {
		
		if (denominator == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	// Simplify fractions
	
	private void simplify() {
		
		int divisor = MathExtra.gcd(numerator, denominator);
		
		numerator /= divisor;
		denominator /= divisor;
		
	}

	// Get numerator
	
	public int getNumerator() {
		return numerator;
	}
	
	// Get denominator
	
	public int getDenominator() {
		return denominator;
	}
	
	// toString override
	
	public String toString() {
		
		String numSlashDen = numerator + "/" + denominator;
		return numSlashDen;
		
	}
	
	// Convert fraction to decimal
	
	public double toDouble() {
		
		return (double) numerator/(double) denominator;
		
	}
	
	// Add two fractions
	
	public static Fraction add(Fraction f1, Fraction f2) {
		
		// For fractions a/b + c/d, common denominator = bd
		int commonDen = f1.denominator * f2.denominator;
		
		// Numerator = ad + bc
		int num = f1.numerator * f2.denominator + f1.denominator * f2.numerator;
		
		return new Fraction(num, commonDen);
		
	}
	
	// Subtract two fractions
	
	public static Fraction subtract(Fraction f1, Fraction f2) {
		
		// For fractions a/b - c/d, common denominator = bd
		int commonDen = f1.denominator * f2.denominator;
		
		// Numerator = ad - bc
		int num = f1.numerator * f2.denominator - f1.denominator * f2.numerator;
		
		return new Fraction(num, commonDen);
		
	}
	
	// Multiply two fractions
	
	public static Fraction multiply(Fraction f1, Fraction f2) {
		
		// For fractions a/b * c/d, numerator = ac
		int num = f1.numerator * f2.numerator;
		
		// Denominator = bc
		int den = f1.denominator * f2.denominator;
		
		return new Fraction(num, den);
		
	}
	
	// Divide two fractions
	
	public static Fraction divide(Fraction f1, Fraction f2) {
		
		// For fractions (a/b) / (c/d), numerator = ad
		int num = f1.numerator * f2.denominator;
		
		// Denominator = bc
		int den = f1.denominator * f2.numerator;
		
		// valid() will return false if c/d = 0
		return new Fraction(num, den);
		
	}
	
}