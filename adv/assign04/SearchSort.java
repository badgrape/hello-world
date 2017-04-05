// Assignment 4
// Jim Morris

package assign04;

public class SearchSort {
	
	// Sequential search: for unsorted arrays
	
	public static int sequentialSearch(int[] array, int item) {
		
		// If array is not empty, call recursive method
		if (array == null || array.length <= 0) {
			return -1;
		}
		else {
			return sequentialSearch_Rec(array, item, 0);
		}
		
	}
	
	public static int sequentialSearch_Rec (int[] array, int item, int index) {
		
		// Base cases:
		
		// Search item found: return index
		if (item == array[index]) {
			return index;
		}
		
		// End of array reached and item not found
		else if (index >= array.length - 1) {
			// message handled by rightTrim method
			return -1;
		}
		
		// Recursion: compare item with next element in array
		else {
			return sequentialSearch_Rec(array, item, index + 1);
		}
	}
	
	// Binary search: for sorted arrays
	
	public static int binarySearch(int[] array, int value) {
		
		// If array is not empty, call recursive method
		if (array == null || array.length == 0) {
			return -1;
		}
		else {
			return binarySearch_Rec(array, 0, array.length - 1, value);
		}
		
	}
	
	public static int binarySearch_Rec(int[] array, int first, int last, int value) {
		
		int mid = (first + last) / 2;
		
		// Base cases
		
		// Search item found
		if (array[mid] == value) {
			return mid;
		}
		
		// End of array reached, search item not found
		else if (first >= last) {
			return -1;
		}
		
		// Recursion:
		else {
			
			// If the search value is less than the middle value,
			// then search the first half of the array
			if (array[mid] > value) {
				return binarySearch_Rec(array, first, mid - 1, value);
			}
			
			// If search value is greater than middle value, 
			// then search second half of array
			else {
				return binarySearch_Rec(array, mid + 1, last, value);
			}
		}
		
	}
	
	// Sort array
	
	public static void selectionSort (int[] array) {
		
		// If array is not null, call recursive method
		if (array != null) {
			selectionSort_Rec(array, 0);
		}
		
	}
	
	public static void selectionSort_Rec(int[] array, int index) {
		
		// Base case: method reaches end of array
		if (index < array.length) {
			
			// First call: find lowest number in array
			// Subsequent call: find lowest number in array subset
			int minIndex = smallestIndex(array, array[index], index, index);
			
			// If smallest index does not equal the current index,
			// then smallest value and current value switch places.
			if (minIndex != index) {
				int temp = array[index];
				array[index] = array[minIndex];
				array[minIndex] = temp;
			}
			
			// Recursion: sort next-smallest value
			selectionSort_Rec(array, index + 1);
		}
		
	}
	
	// minValue = smallest value at end of previous call
	// index = item evaluated in current call
	// minIndex = index of smallest value
	public static int smallestIndex(int[] array, int minValue, int index, int minIndex) {
		
		// Base case: method reaches end of array: return index of smallest value
		if (index >= array.length) {
			return minIndex;
		}
		
		// Recursion
		else {
			
			// If current value is less than smallest, then current is smallest
			// and current index is index of smallest value
			if (array[index] < minValue) {
				minValue = array[index];
				minIndex = index;
			}
			
			// Check if next value is even smaller
			return smallestIndex(array, minValue, index + 1, minIndex);
		}
		
	}
		
}
