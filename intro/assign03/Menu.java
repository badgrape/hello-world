package assign03;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static Scanner console = new Scanner(System.in);

    // List of menu options
    public static String[] menuList() {
		
    	String[] options = {
            "(1) Ch5 ex1: Individual digits and sum of digits",
           	"(2) Ch5 ex9: Odds and evens between two integers, and more!",
           	"(3) Ch7 ex1: Determine if a character is a vowel",
           	"(4) Ch7 ex2: Count the vowels in a string",
           	"(5) Ch7 ex6: Reverse a number's digits",
           	"(6) Ch7 ex11: Determine if a number is a palindrome",
           	"(7) Ch7 ex12-13: Determine if a number is a prime palindrome!",
           	"(8) Part 2a: Guess that number",
           	"(9) Part 2b: Get the average of a five-digit number",
           	"(10) Part 2c: Convert phone letters to digits",
           	"(11) Exit the program"
    	};
    	
    	return options;
    	
    }
    
    // Return number of options based on menu() array size
    public static int numberOptions(String[] list) {
    	
    	int thisManyOptions = list.length;
    	return thisManyOptions;
    	
    }
    
    public static void displayMenu(String[] options) {
    	
        System.out.println("Welcome to Java assignment 3!\n");
        
        for (int i = 0; i < options.length; i++) {
        	
        	System.out.println(options[i]);
        	
        }
        
        System.out.print("\nEnter your choice: ");       

    }

    public static int getUserMenuOption(int numOptions) {
    	
        int selection = console.nextInt();

        while (selection < 1 || selection > numOptions) {
        	
            System.out.print("Invalid option, try again: ");
            selection = console.nextInt();
            
        }
        
        return selection;
        
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        
    	boolean exitRequested = false;

        while (exitRequested == false) {
        	
            displayMenu(menuList());

            // maximum allowed choice set with size of menu() array
            int maxChoice = numberOptions(menuList());
            
            int selection = getUserMenuOption(maxChoice);
            
        	System.out.println();

            switch (selection) {
                case 1:
                    Chapter05.exerciseOne();
                    break;
                case 2:
                	Chapter05.exerciseNine();
                	break;
                case 3:
                	Chapter07.exerciseOneUI();
                	break;
                case 4:
                	Chapter07.exerciseTwoUI();
                	break;
                case 5:
                	Chapter07.exerciseSixUI();
                	break;
                case 6:
                	Chapter07.exerciseElevenUI();
                	break;
                case 7:
                	Chapter07.exerciseThirteenUI();
                	break;
                case 8:
                	Part02.guessTheNumber();
                	break;
                case 9:
                	Part02.averageDigits();
                	break;
                case 10:
                	Part02.requestPhoneNumber();
                	break;
                case 11:
                    exitRequested = true;
                    break;
                default:
                    System.out.println("Invalid option!!!");
            }
            
            // Make program wait 3 seconds before showing the menu again
            Thread.sleep(3000);
            
        	System.out.println("\n=============================================================\n");

        }
        
    }

}