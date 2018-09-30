package Basics;
import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava {
	//Print 1-255
	public int[] printAll() {
		int[] arr;
		arr = new int[255];
		for(int i = 0; i<255; i++) {
			arr[i] = i+1;
		};
		return arr;
	}
	//Print odd numbers between 1-255
	public ArrayList<Integer> printOdd() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0; i<255;i++) {
			if(i%2 != 0) {
				arr.add(i);
			}
		}
		return arr;
	}
	
	//Print Sum (including the number added)
	//using an array:
	public String[] printSum() {
		String[] arr;
		arr = new String[256];
		int sum = 0;
		for(int i = 0; i<256; i++) {
			sum += i;
			arr[i]=String.format("New number: %s Sum: %s", i, sum);
		}
		return arr;
	}
	//Without an array:
	public void newSum() {
		int sum = 0;
		for (int i = 0; i<=255; i++) {
			sum += i;
			System.out.println(String.format("New number: %s Sum: %s", i, sum));
		}
	}
	
	//iterating through an array
	public void iterateArr(int[] arr) {
		for(int i = 0; i< arr.length;i++) {
//			System.out.println(Arrays.toString(arr));
			System.out.println(arr[i]);
		}
	}
	
	//Find max
	public Integer findMax(int[] arr) {
		if(arr.length == 0) {
			return null;
		}else if(arr.length == 1) {
			return arr[0];
		}else {
			int max = arr[0];
			for(int i = 1; i< arr.length; i++) {
				if(arr[i]>max) {
					max = arr[i];
				}
			}
			return max;
		}
	}
	
	//Find min
	public Integer findMin(int[] arr) {
		if(arr.length == 0) {
			return null;
		}else if(arr.length == 1 ) {
			return arr[0];
		}else {
			int min = arr[0];
			for(int i = 1; i< arr.length; i++) {
				if(arr[i]< min) {
					min = arr[i];
				}
			}
			return min;
		}
	}
	
	//Get Average
	public Double getAverage(int[] arr) {
		double length = arr.length;
		if(arr.length == 0) {
			return null;
		}else if(arr.length == 1){
			double singleAverage = arr[0];
			return singleAverage;
		}else{
			int sum = arr[0];
			for(int i = 1; i < length; i++) {
				sum += arr[i];
			}
			double average = sum/length;
			return average;
		}
	}
	
	//Array with Odd Numbers
	// see printOdd() method;
	
	//Greater than Y
	public int greaterY(int[] arr, int y) {
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > y) {
				counter++;
			}
		}
		return counter;
	}
	
	//Square the values
	public int[] squareValue(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (int) Math.pow(2, arr[i]);
			arr[i] = arr[i]*arr[i];
		}
		return arr;
	}
	
	//Eliminate the Negative Numbers
	public int[] noNeg(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] < 0) {
				arr[i] = 0;
			}
		}
		return arr;
	}
	
	//Max, Min, and Average
	public Object[] maxMinAverage(int[] arr) {
		Object[] newArr;
		newArr = new Object[3];
		newArr[0] = findMax(arr);
		newArr[1] = findMin(arr);
		newArr[2] = getAverage(arr);
		return newArr;
		
	}
	
	//Shifting the values in the array
	public int[] shiftValues(int[] arr) {
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1]= 0; 
		return arr;
	}
}
