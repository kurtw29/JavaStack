package Puzzling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PuzzleJavaTest {
	public static void main(String[] args) {
		PuzzleJava task = new PuzzleJava();
		
		//Task: given an array -> print sum of all numbers and return array of values greater than 10;
		int[] arrNum = {3,5,1,2,7,9,8,13,25,32};
		System.out.println(task.greaterTen(arrNum));
		
		//Create Array with the values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa.
		//Shuffle the array and print the name of each person
		//Return the array with names that are longer than 5 characters;
		ArrayList<String> nameArr = new ArrayList<String>(Arrays.asList("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"));
		System.out.println("shuffled array with names > 5 characters: "+task.arrNames(nameArr));
		
		//Given array, shuffle it, display last letter from array & first letter of array, if first = vowel, display a message
		ArrayList<Character> arrCharacters = new ArrayList<Character>();
		arrCharacters.add('a');
		arrCharacters.add('b');
		arrCharacters.add('c');
		arrCharacters.add('d');
		arrCharacters.add('e');
		arrCharacters.add('f');
		arrCharacters.add('g');
		arrCharacters.add('h');
		arrCharacters.add('i');
		arrCharacters.add('j');
		arrCharacters.add('k');
		arrCharacters.add('l');
		arrCharacters.add('m');
		arrCharacters.add('n');
		arrCharacters.add('o');
		arrCharacters.add('p');
		arrCharacters.add('q');
		arrCharacters.add('r');
		arrCharacters.add('s');
		arrCharacters.add('t');
		arrCharacters.add('u');
		arrCharacters.add('v');
		arrCharacters.add('w');
		arrCharacters.add('x');
		arrCharacters.add('y');
		arrCharacters.add('z');
		System.out.println(task.letter(arrCharacters));
		
		//Generate an array with 10 random numbers between 55-100
		System.out.println(Arrays.toString(task.arrRandomInt()));
		
		//Sort the previous generated array, then display minimum value and maximum value
		ArrayList<Integer> arrSorted = task.arrSortedRandomInt();
		//System.out.println(task.arrSortedRandomInt());
		System.out.println(String.format("Array: %s. \nMinimum value: %s.\nMaximum value: %s.", arrSorted, arrSorted.get(0), arrSorted.get(9)));
		
		// Create a random string that is 5 characters long
		System.out.println(task.arrRandomString(arrCharacters));
		
		//Create an array of 10 random string that is 5 characters long
		System.out.println(Arrays.toString(task.arrTenRandomStrings(arrCharacters)));
	}
}
