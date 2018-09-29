//This is for practicing the platform's codes
public class TestGround {
	public static void main(String[] args) {
		String ninja = "coding Dojo!@#$";
		int nLength = ninja.length();
		String madeUp = "15";
		String comment = "[concat()] The length of ninja string is: ";
		System.out.println("[+ concatenation] The length of ninja string is: "+nLength);
		System.out.println(comment.concat(madeUp));
		System.out.println(String.format("%s The length of ninja string is: %s", "[format method]", nLength));
		int t = comment.indexOf("oncat");
		int e = comment.indexOf("pizza");
		System.out.println("indexOf 'oncat': "+ t);
		System.out.println("indexOf 'pizza': "+ e);
		System.out.println("indexOf 'ninja' inside printline: "+comment.indexOf("ninja"));
	}
}
