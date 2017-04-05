package assign04;

public class ConsoleOutput {
	
	// Generate unsorted random array

	public static int[] randomArray_Rec(int[] array, int index) {
		
		if (index == array.length) {
			return array;
		}
		
		else {
			array[index] = (int) (Math.random() * 15);
			return randomArray_Rec(array, index + 1);
		}
		
	}
	
	public static int[] randomArray(int length) {
		
		int[] array = new int[length];
		return randomArray_Rec(array, 0);
		
	}
	
	// Print array
	
	public static void printArray_Rec(int[] array, int index) {
		
		if (array == null || array.length <= 0) {
			System.out.println("");
		}
		else if (index < array.length) {
			System.out.print(array[index] + " ");
			printArray_Rec(array, index + 1);
			
		}
		else {
			System.out.println();
		}
		
	}
	
	public static void printArray(int[] array) {
		printArray_Rec(array, 0);
	}
	
	// Message handling
	
	public static void message(int[] original, int[] parsed, int index) {
		if (original == null || original.length == 0) {
			System.out.println("Array is empty.");
		}
		
		else if (index > original.length - 1) {
			System.out.println("Index out of range.");
		}
		
		else if (original.equals(parsed)) {
			System.out.println("Value does not exist.");
		}
		
		else {
			System.out.println("Operation successful.");
		}
	}
	
	// Print output from remove methods
	// Parameters: op = characters 'a' through 'f': each corresponds to a method
	// value = item or index, depending whether method is remove or removeAt
	public static void runRemoveMethod(char op, int[] array, int value) {
		
		// Print "(Un)sorted array" depending on method being called
		System.out.print((op == 'a' || op == 'b' || op == 'c' ? "Uns": "S")
			+ "orted array:\t\t");
		
		// Sort arrav for sortedRemove methods
		if (op == 'd' || op == 'e' || op == 'f') {
			SearchSort.selectionSort(array);
		}
		
		printArray(array);
		
		// Print name of method
		System.out.print((op == 'a' || op == 'b' || op == 'c' ? "r" : "sortedR")
			+ "emove" + (op == 'b' || op == 'e' ? "At" : "")
			+ (op == 'c' || op == 'f' ? "All" : "") + "(" + value + "):\t"
			+ (op == 'a' || op == 'b' || op == 'c' ? "\t" : ""));
		
		// Instatiate array to contain return value
		int[] removed = null;
		
		// Call method based on value of op
		switch(op) {
			case 'a': removed = Remove.remove(array, value);
			break;
			case 'b': removed = Remove.removeAt(array, value);
			break;
			case 'c': removed = Remove.removeAll(array, value);
			break;
			case 'd': removed = Remove.sortedRemove(array, value);
			break;
			case 'e': removed = Remove.sortedRemoveAt(array, value);
			break;
			case 'f': removed = Remove.sortedRemoveAll(array, value);
			break;
		}
		
		// Print return value
		printArray(removed);
		
		// Print message
		System.out.print("Message:\t\t");
		
		// Condition for "index out of range"
		if (op == 'b' || op == 'e') {
			message(array, removed, value);
		}
		else {
			message(array, removed, 0);
		}
		
		System.out.println();

	}
	
	// Main
	
	public static void main(String[] args) {
		
		// remove
		runRemoveMethod('a', randomArray(15), 3);
		// removeAt
		runRemoveMethod('b', randomArray(15), 5);
		// removeAll
		runRemoveMethod('c', randomArray(15), 8);
		// sortedRemove
		runRemoveMethod('d', randomArray(15), 12);
		// sortedRemoveAt
		runRemoveMethod('e', randomArray(15), 14);
		// SortedRemoveAll
		runRemoveMethod('f', randomArray(15), 0);
		
	}
	
}
