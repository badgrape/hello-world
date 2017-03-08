// Chapter 3, exercise 7
// Jim Morris

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ch3_ex7 {
	
	public static void main (String[] args) throws FileNotFoundException {
		
		Scanner count = new Scanner(new FileReader("ch3ex7_data.txt"));
		
		// Count lines in the input file, to determine size of data arrays
		int lines = 0;
		while (count.hasNextLine()) {
			  lines++;
			  count.nextLine();
		}
				
		count.close();
		
		// Re-initialize reader, so that it begins at line 1
		Scanner read = new Scanner(new FileReader("ch3ex7_data.txt"));
		
		// Initialize output file
		PrintWriter write = new PrintWriter("ch3ex7_output.dat");		
		
		String[] lname = new String[lines];
		String[] fname = new String[lines];
		double[] csal = new double[lines]; // current salary
		double[] incr = new double[lines]; // percent of increase
		double[] raise = new double[lines]; // updated salary
		
		int i = 0; // initialize counter
		
		// Write column headings to output file
		write.printf("%-15s %-15s %s %n", "firstName", "lastName", "updatedSalary");
		
		while (read.hasNextLine()) {
			
			// Read file contents and save data in arrays
			lname[i] = read.next();
			fname[i] = read.next();
			csal[i] = read.nextDouble();
			incr[i] = read.nextDouble();
			
			// Calculate new salary
			raise[i] = (csal[i] * (incr[i] / 100)) + csal[i];
			
			// Write data to output file
			write.printf("%-15s %-15s $%.2f %n", fname[i], lname[i], raise[i]);
			
		}
		
		read.close();
		write.close();
		
	}
	
}