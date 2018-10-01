package Puzzling;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class PuzzleJava {
	//Print sum of number and return array with numbers greater than 10
	public ArrayList<Integer> greaterTen(int[] arr) {
		int sum = 0;
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(arr[i] > 10) {
				newArr.add(arr[i]);
			}
		}
		System.out.println("Sum: "+sum);
		return newArr;
	}
	
	//Create array of names (strings), shuffle array, print each name, return array of names greater than 5 characters
	public ArrayList<String> arrNames(ArrayList<String>arr) {
		ArrayList<String> newArr = new ArrayList<String>();
		Collections.shuffle(arr);
		for(int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i));
			System.out.println("arr.get(i).length(): "+ arr.get(i).length());
			if(arr.get(i).length() > 5) {
				newArr.add(arr.get(i));
			}
		}
		return newArr;
	}
	
	//Given array, shuffle it, display last letter from array & first letter of array, if first = vowel, display a message
	public String letter(ArrayList<Character> arr) {
//		System.out.println(arr);
		Collections.shuffle(arr);
//		System.out.println(arr);
		if(arr.get(0) == 'a' || arr.get(0) == 'e' || arr.get(0) == 'i' || arr.get(0) == 'o' || arr.get(0) == 'u'){
			return String.format("Last letter from shuffled alphabets array: %s. \nFirst letter: %s is a vowel!", arr.get(arr.size()-1), arr.get(0));
		}else {
			return String.format("Last letter from shuffled alphabets array: %s. \nFirst letter: %s", arr.get(arr.size()-1), arr.get(0));
		}
	}
	
	//generate and return array with 10 random numbers between 55-100
	public int[] arrRandomInt() {
		int[] arr = new int[10];
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(46)+55;
		}
		return arr;
	}
	
	public ArrayList<Integer> arrSortedRandomInt() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			arr.add(r.nextInt(46)+55);
		}
		Collections.sort(arr);
		return arr;
	}
	
	public String arrRandomString(ArrayList<Character> arr) {
		char[] arrRandChar = new char[5];
		Random r = new Random();
		for(int i = 0; i < 5; i++) {
			arrRandChar[i] = arr.get(r.nextInt(26));
		}
//		System.out.println(arrRandChar);
		String arrRandStr = new String(arrRandChar);
		return arrRandStr;
	}
	
	//Create an array of 10 random string that is 5 characters long
	public String[] arrTenRandomStrings(ArrayList<Character> arr) {
		String[] arrTen = new String[10];
		for(int i = 0; i < 10; i++) {
			arrTen[i] = arrRandomString(arr);
		}
		return arrTen;
	}
}
