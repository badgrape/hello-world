// Chapter 5, exercise 9
// Jim Morris

import java.util.Scanner;

public class ch5_ex9 {
	
	public static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int i = 0; // initialize counter
		
		// a. Prompt the user to enter two integers
		
		int firstNum = 0;
		int secondNum = 0;
		while (i < 2) {
			
			System.out.print("Enter the " + (i == 0 ? "first" : "second") + " number: ");
			
			if (i == 0) {
				firstNum = console.nextInt();
			}
			
			else {
				secondNum = console.nextInt();
				while (firstNum > secondNum) {
					System.out.print("The second number must be greater than the first. Try again: ");
					secondNum = console.nextInt();
				}
			}
			
			i++;
		}
		
		// Calculate difference between first and second numbers. Needed for b, c and e
		
		int diffNums = secondNum - firstNum;
		System.out.println("The difference is " + diffNums); // for debugging
		
		// b. Output all the odd numbers between first and second numbers inclusive
		
		String oddNums = ""; // string of odd numbers; used also in e
		
		int currNum = 0; // current number in any iteration
		
		i = 0; // reset counter
		
		while (i < diffNums) {
			
			currNum = firstNum + i;
			
			// Add odd numbers to string
			if (currNum % 2 == 1) {
				oddNums += currNum + " ";
			}
						
			i++;
		
		}
		
		System.out.println(oddNums + " ");
				
		// c. Output the sum of all even numbers between first and second numbers inclusive
		
		/*int vsum = 0;
		int oddSq = 0;
		
		String evens = "";
		String oneten = "";
		String testsq = "";
		
		while (count <= diff) {
			
			cnum = num1 + count;
			
			if (cnum %2 == 1) {
				odds += cnum + " ";
				testsq +=  (int) Math.pow(cnum, 2) + " ";
				oddSq += (int) Math.pow(cnum, 2);
			}
			
			else if (cnum %2 == 0) {
		    	vsum = vsum + cnum;
		        evens += cnum + " ";
		    }
			
			else if (cnum >= 1 && cnum <= 10) {
				oneten += cnum + " ";
			}
			
		    count++;
		}
		
		System.out.println("The odd numbers: " + odds);
		System.out.println("The even numbers: " + evens);
		System.out.println("Sum of even numbers: " + vsum);
		System.out.println("Squares of all the odd numbers: " + testsq);
		System.out.println("Sum of the squares of all the odd numbers: " + oddSq);*/
		
	}
	
}