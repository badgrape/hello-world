// Assignment 3
// Jim Morris

public class assign03 {

	public static void row(int width) {
		if (width > 0) {
			System.out.print('*');
			row(width - 1);
		}
	}
	public static void triangles(int width) {
		
		if (width > 0) {
			row(width);
			System.out.println();
			triangles(width - 1);
		}
		
		
	}
	
	// Main
	public static void main(String[] args) {
		
		triangles(5);
		
	}
	
}
