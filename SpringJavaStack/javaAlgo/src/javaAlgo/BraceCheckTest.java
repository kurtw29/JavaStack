package javaAlgo;

public class BraceCheckTest {
	public static void main(String[] args) {
		BraceChecker braceCheck = new BraceChecker();
		char[] arr = {'(', '{','[',']','}',')'};
		char[] arr2 = {'(', '{','[',']','}',')',')'};
		char[] arr3 = {'(', '{','[',']','}','}'};		
		System.out.println("arr: "+braceCheck.checkBraces(arr));
		System.out.println("arr2: "+braceCheck.checkBraces(arr2));
		System.out.println("arr3: "+braceCheck.checkBraces(arr3));
	}

}
