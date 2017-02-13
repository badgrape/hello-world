package menuapplication;

import java.io.IOException;
import java.util.Scanner;

public class MenuApplication {

    public static Scanner console = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("Welcome to the Menu Applcation!\n");
        System.out.println("1- Calculate how many letter A in a string");
        System.out.println("2- Quit Program\n");
        System.out.print("Enter your choice: ");

    }

    public static int getUserMenuOption(int numOptions) {
        int option = console.nextInt();

        while (option < 1 || option > numOptions) {
            System.out.print("Invalid option, try again: ");
            option = console.nextInt();
        }

        return option;
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        boolean exitRequested = false;

        while (exitRequested == false) {
            displayMenu();
            int choice = getUserMenuOption(2);

            switch (choice) {
                case 1:
                    System.out.println("Option 1");
                    break;
                case 2:
                    exitRequested = true;
                    break;
                    
                default:
                    System.out.println("Invalid option!!!");
            }
            
            // Make program wait 3 seconds before showing the menu again
            Thread.sleep(3000);
        }
        

    }

}
