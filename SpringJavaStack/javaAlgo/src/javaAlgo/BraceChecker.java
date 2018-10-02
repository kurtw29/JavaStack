package javaAlgo;
import java.util.ArrayList;

public class BraceChecker {
	public boolean checkBraces(char[] braces) {
		ArrayList<Character> braceArr = new ArrayList<Character>();
		for( int i = 0; i < braces.length; i++) {
			if(braces[i] == '(' || braces[i] == '[' || braces[i] == '{') {
				braceArr.add(braces[i]);
			}else {
				char openBrace = braceArr.remove(braceArr.size()-1);
				if(openBrace == '(' && braces[i] != ')') {
					return false;
				}else if( openBrace == '{' && braces[i] != '}') {
					return false;
				}else if( openBrace == '[' && braces[i] != ']') {
					return false;
				}
			}
		}
		if(braceArr.size() == 0) {
			return true;
		}else {
			return false;
		}
	}
}
