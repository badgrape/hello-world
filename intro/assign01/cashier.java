// Cashier's algorithm
// Jim Morris

import java.util.Scanner;

public class cashier {

    static Scanner console = new Scanner(System.in);    
    
    public static void main(String[] args) {
    
        System.out.print ("How much money do you want changed? $");
        
        double money = console.nextDouble();
                
        // Isolate dollars with type casting
        int dollars = (int) (money);
        
        // Isolate cents by re-casting dollars as double and subtracting
        double calccents = (money - (double)(dollars)) * 100;
        
        // Round to the nearest 5 cents, since pennies are out of circulation
        calccents = 5 * Math.round(calccents/5);
        
        int cents = (int) (calccents);
        
        System.out.println("\nMaking change for $" + dollars + "." + cents);
        
        int i; // Initialize counter variable for loops
        
        System.out.println("\nBreakdown of your change:");
        
        // Calculate the number of dollar bills and coins
        int[] dollarunits = {100, 50, 20, 10, 5, 2, 1};
        
        for (i = 0; i < dollarunits.length; i++) {
            int units = dollars / dollarunits[i];
            dollars = dollars % dollarunits[i];
            System.out.println(units + " x " + dollarunits[i] + "$");
        }
        
        // Calculate the number of cent pieces
        int[] centunits = {25, 10, 5};
        
        for (i = 0; i < centunits.length; i++) {
        	int units = cents / centunits[i];
        	cents = cents % centunits[i];
        	System.out.println(units + " x " + centunits[i] + "c");
        }
        
    }
    
}