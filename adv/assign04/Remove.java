// Assignment 4
// Jim Morris

package assign04;

public class Remove {
	
	// "Remove" item from array by replacing it with value immediately to the left,
	// and so on, shifting all remaining values by one index (item[index] = item[index + 1]).
	// Then create a new array containing all the original values except the item matched
	// by the search method. Thus, the array is "trimmed" of the last item on the right.
	
	public static int[] rightTrim(int[] array, int index) {
		
		// Base cases:
		
		// Array empty
		if (array == null || array.length <= 0) {
			return array;
		}
		
		// Value does not exist: -1 returned by search method
		else if (index < 0) {
			return array;
		}
		
		// Index out of range
		else if (index > array.length - 1) {
			return array;
		}
		
		// Method reaches end of array
		else if (index >= array.length - 1) {
			
			// Create array with one less item, populating it will all elements
			// except the last, thereby "removing" the appropriate value
			int[] trimmed = new int[array.length - 1];
			return shrink(array, trimmed, 0);
		}
		
		// Recursion: overwrite current value with next value
		else {
			array[index] = array[index + 1];
			return rightTrim(array, index + 1);
		}
	}
	
	// Create an array, based on the original, but with one less item.
	
	public static int[] shrink(int[] larger, int[] smaller, int index) {
		
		// Base case: method reaches end of smaller array.
		// Omits final, undesired element of larger array.
		if (index >= smaller.length) {
			return smaller;
		}
		
		// Recursion: copy value from larger array into smaller
		// at the corresponding index. Do the same with the next element.
		else {
			smaller[index] = larger[index];
			return shrink(larger, smaller, index + 1);
		}
		
	}
	
	// Question 1
	
	public static int[] remove(int[] array, int item) {
		
		// Remove element at index isolated by sequentialSearch
		return rightTrim(array, SearchSort.sequentialSearch(array, item));
		
	}
	
	// Question 2
	
	public static int[] removeAt(int[] array, int index) {
		
		// Remove element at index specified in parameter
		return rightTrim(array, index);
		
	}
	
	// Question 3
	
	public static int[] removeAll(int[] array, int item) {
		
		int index = SearchSort.sequentialSearch(array, item);
		
		// Base case: item does not exist
		if (index >= 0) {
			
			// Recursion: remove first and all subsequent occurrences of item
			return removeAll(rightTrim(array, index), item);
			
		}
			
		else {
			return array;
		}
		
	}
	
	// Question 4
	
	public static int[] sortedRemove(int[] array, int item) {
		
		// Remove element at index isolated by binarySearch
		return rightTrim(array, SearchSort.binarySearch(array, item));
		
	}
	
	public static int[] sortedRemoveAt(int[] array, int index) {
		
		// method identical for sorted and unsorted arrays
		return removeAt(array, index);
		
	}
	
	public static int[] sortedRemoveAll(int[] array, int item) {
		
		int index = SearchSort.binarySearch(array, item);
		
		// Base case: item not found
		if (index >= 0) {
			
			// Recursion: remove first and any subsequent instances of item
			return sortedRemoveAll(rightTrim(array, index), item);
		}
			
		else {
			return array;
		}
		
	}
}
