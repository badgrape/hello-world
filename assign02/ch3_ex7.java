// Chapter 3, exercise 7
// Jim Morris

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ch3_ex7 {
	
	public static void main (String[] args) throws FileNotFoundException {
		
		// Count number of lines in the input file, for read loop
		Scanner count = new Scanner(new FileReader("ch3ex7_data.txt"));
		
		int lines = 0;
		while (count.hasNextLine()) {
			  lines++;
			  count.nextLine();
			}
		
		System.out.println(lines);
		
		count.close();
		
		// Read file contents and save data in arrays
		Scanner read = new Scanner(new FileReader("ch3ex7_data.txt"));
		
		String[] lname = new String[lines];
		String[] fname = new String[lines];;
		double[] csal = new double[lines];
		double[] incr = new double[lines];;
		
		int i; // initialize counter
		
		for (i = 0; i < lines; i++) {
			
			lname[i] = read.next();
			fname[i] = read.next();
			csal[i] = read.nextDouble();
			incr[i] = read.nextDouble();
			
			System.out.println(lname[i] + fname[i] + csal[i] + incr[i]);
			
		}
		
		read.close();
		
		PrintWriter write = new PrintWriter("ch3ex7_output.dat");
		
		write.printf("%-15s %-15s %s", "firstName", "lastName", "updatedSalary");
		
		for (i = 0; i < lines; i++) {
			
			
			
		}
		
		write.close();
		
	}
	
}