import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class guess {
	
	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner infile = new Scanner(new FileReader("guess_value.txt"));
		
		// Read from the file
		int realnum = infile.nextInt(); // number contained in the file
		
		infile.close();
				
		// Enter and evaluate first guess
		System.out.print("Guess the value in the file: ");
		
		int guessnum = console.nextInt();
		
		if (realnum != guessnum) { // if the first guess is wrong
		
			// Finish evaluating first guess, then enter and evaluate remaining guesses
			for (int i = 0; i < 4; i++) {
				
				if (realnum > guessnum) {
					System.out.printf("The value is greater than %d. Guess again: ", guessnum);
					guessnum = console.nextInt();
				}
				
				else if (realnum < guessnum) {
					System.out.printf("The value is less than %d. Guess again: ", guessnum);
					guessnum = console.nextInt();
				}
				
				// Exit loop if subsequent guess is correct
				else {break;}
			
			}
		}
		
		// Print win or lose message
		if (realnum == guessnum) {
			System.out.println("Congratulations, you got it! :)");
		}
			
		else {
			System.out.println("You lose :(");
		}
	}
	
}