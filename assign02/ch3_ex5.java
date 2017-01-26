import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Chapter 3, exercise 5
// Jim Morris

public class ch3_ex5 {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		int i;
		
		String[] cats = {
			"GENERAL",
			"PREMIUM",
			"SIDELINE",
			"BOX"
		};
		
		int[] sold = new int[cats.length];
		
		for (i = 0; i < cats.length; i++) {
		
			System.out.print("Number of " + cats[i] + " tickets sold: ");
			sold[i] = console.nextInt();
			
		}
		
		double[] price = {25, 50, 100, 250};
		
		PrintWriter outfile = new PrintWriter ("ch3ex5_out.txt");
		
		outfile.printf("%-15s %-15s %-20s %s %n",
			"TicketCategory", "TicketPrice", "NumberOfTicketsSold", "SubTotal");
		
		double[] subtotal = new double[cats.length];
		
		for (i = 0; i < cats.length; i++) {
			
			subtotal[i] = price[i] * sold[i];
			outfile.printf("%-15s $%-14.2f %-20d $%.2f %n",
					cats[i], price[i], sold[i], subtotal[i]);
			
		}

		// Calculate and print total sales for the day
		i = 0;
		double total = 0;
		
		while(i < cats.length) {
			total += subtotal[i];
			i++;
		}
		
		outfile.printf("%-52s $%.2f", "Total", total);
		
		outfile.close();
		
	}
	
}