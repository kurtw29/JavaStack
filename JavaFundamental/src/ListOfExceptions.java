import java.util.ArrayList;
public class ListOfExceptions {
	public static void main(String[] arg) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("13");
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");
		for(int i = 0; i < myList.size(); i++) {
			try {
				Integer castedValue = (Integer) myList.get(i);
				System.out.println("Casted value: "+myList.get(i));
			}catch (Exception e) {
				System.out.println("Error in casting elements from String to Integer." + e);
			}
		}
	}
}
