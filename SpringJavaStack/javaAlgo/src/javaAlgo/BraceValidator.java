package javaAlgo;

import java.util.HashMap;

public class BraceValidator {
	
	public HashMap<Character, Character> braceMap = new HashMap<Character, Character>();
	
	public BraceValidator() {
		this.braceMap.put('{', '}');
		this.braceMap.put('[', ']');
		this.braceMap.put('(', ')');		
	}
		
	

}
