package Basics;
import java.util.Arrays;
public class BasicJavaTest {
	public static void main(String[] args) {
		BasicJava basic = new BasicJava();
		
////		print 1-255
//		int[] pAll= basic.printAll();
//		System.out.println(Arrays.toString(pAll));
		
////		print odd numbers between 1-255;
//		System.out.println(basic.printOdd());
		
//		//print sum of numbers from 0 to 255 including the index number (without using an array)
//		basic.newSum();
		
//		//Iterate through a given array and printout its value
//		int[] arr = {1,23,3,4,65, 209};
//		basic.iterateArr(arr);
		
//		//Find Max
//		int[] arr = {-1,-2,-3,-24};
//		System.out.println("Max of negative values: "+basic.findMax(arr));
//		int[] arr2 = {0, -12, 14,2};
//		System.out.println("Max of mix values: "+basic.findMax(arr2));
//		int[] arrZero = {-12,-1,0,-5};
//		System.out.println("Max of negative w/ 0: "+basic.findMax(arrZero));
		
//		//Get Average
//		int[] arr1 = {1, 2, 3, 4, 5};
//		System.out.println("the average is: "+basic.getAverage(arr1));
//		int[] arr2 = {5};
//		System.out.println("the average is: "+basic.getAverage(arr2));
//		int[] arr3 = {-1,-2,-3,-24};
//		System.out.println("the average is: "+basic.getAverage(arr3));
//		int[] arr4 = {0, -12, 14,2};
//		System.out.println("the average is: "+basic.getAverage(arr4));
		
//		//Array with Odd Numbers
//		System.out.println(basic.printOdd());
		
//		//Greater than Y
//		int[] arr = {-1, 0, 20, 4, -20};
//		int y = -5;
//		System.out.println(basic.greaterY(arr, y));
		
//		//Square the values
//		int[] arr = {1, 5, 10, -2};
//		int[] newArr = basic.squareValue(arr);
//		System.out.println(Arrays.toString(newArr));
		
//		//Eliminate the Negative numbers
//		int[] arr = {1, -5, 10, -2};
//		int[] newArr = basic.noNeg(arr);
//		System.out.println(Arrays.toString(newArr));
		
//		//Max, Min, and Average
//		int[] arr1 = {1, 2, 3, 4, 10};
//		System.out.println(Arrays.toString(basic.maxMinAverage(arr1)));
//		int[] arr2 = {-1,-2,4,10};
//		System.out.println(Arrays.toString(basic.maxMinAverage(arr2)));
//		int[] arr3 = {0, -1,-5, 20};
//		System.out.println(Arrays.toString(basic.maxMinAverage(arr3)));
	
		//Shifting the values in the array
		int[] arr = {1, 5, 10, 7, -2, 100, 0};
		System.out.println(Arrays.toString(basic.shiftValues(arr)));
	}
}
