package Puzzling;

public class PuzzleJavaTest {
	public static void main(String[] args) {
		PuzzleJava task = new PuzzleJava();
		
		//Task: given an array -> print sum of all numbers and return array of values greater than 10;
		int[] arr = {3,5,1,2,7,9,8,13,25,32};
		System.out.println(task.greaterTen(arr));
		
		//Create Array with the values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa.
		//Shuffle the array and print the name of each person
		//Return the array with names that are longer than 5 characters;
		String[] arrNames = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
	}
}
