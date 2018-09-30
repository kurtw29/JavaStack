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
	
	public String[] arrNames(ArrayList<String>arr) {
		Collections.shuffle(arr);
		return arr;
	}
}
