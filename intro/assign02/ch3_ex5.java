// Chapter 3, exercise 5
// Jim Morris

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ch3_ex5 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		// Initialize file input and output
		Scanner infile = new Scanner(new FileReader("ch3ex5_in.txt"));
		PrintWriter outfile = new PrintWriter ("ch3ex5_out.txt");
		
		String[] cats = { // ticket categories
			"BOX",
			"SIDELINE",
			"PREMIUM",
			"GENERAL"
		};
		
		double[] price = new double[cats.length]; // price for each kind of ticket
		
		int[] sold = new int[cats.length]; // number of each kind sold
		
		double[] subtotal = new double[cats.length]; // money made on each kind
		
		int i = 0; // initialize counter
		
		// Write column headings to outfile
		outfile.printf("%-15s %-15s %-20s %s %n",
			"TicketCategory", "TicketPrice", "NumberOfTicketsSold", "SubTotal");
		
		while (infile.hasNextLine()) {
		
			// Save infile contents to arrays
			price[i] = infile.nextDouble();
			sold[i] = infile.nextInt();
			
			// Calculate subtotals
			subtotal[i] = price[i] * sold[i];
			
			// write data to outfile
			outfile.printf("%-15s $%-14.2f %-20d $%.2f %n",
					cats[i], price[i], sold[i], subtotal[i]);
			
			i++;
			
		}
		
		// Calculate grand totals
		
		double tickets = 0; // total number of tickets sold
		double total = 0; // total revenue
		
		i = 0;
		
		while(i < cats.length) {
			
			tickets += sold[i];
			total += subtotal[i];
			i++;
			
		}
		// Write grand totals
		outfile.printf("%-31s %-20.0f $%.2f", "Totals", tickets, total);
		
		infile.close();
		outfile.close();
		
	}
	
}