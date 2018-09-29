package StringManipulation;

public class StringManipulatorTest {
	public static void main(String[] args) {
		System.out.println("trimAndConcat()");
		StringManipulator manipulator = new StringManipulator();
		String str = manipulator.trimAndConcat("    Hello     ","     World    ");
		System.out.println(str);
		System.out.println("getIndexOrNull(string, char)");
		char letter = 'o';
		Integer a = manipulator.getIndexOrNull("Coding", letter);
		Integer b = manipulator.getIndexOrNull("Hello World", letter);
		Integer c = manipulator.getIndexOrNull("Hi", letter);
		System.out.println(a); // 1
		System.out.println(b); // 4
		System.out.println(c);
		System.out.println("getIndexOrNull(word, substring)");
		String word = "Hello";
		String subString = "llo";
		String notSubString = "world";
		Integer ab = manipulator.getIndexOrNull(word, subString);
		Integer bb = manipulator.getIndexOrNull(word, notSubString);
		System.out.println(ab); // 2
		System.out.println(bb); // null
		System.out.println("concateSubstring()");
		String wordd = manipulator.concatSubstring("Hello", 1, 2, "world");
		System.out.println(wordd);
	}

}
