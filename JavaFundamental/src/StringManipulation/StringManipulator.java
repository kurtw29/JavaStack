package StringManipulation;

public class StringManipulator {
	public String trimAndConcat(String str1, String str2 ) {
		String outcome = str1.trim()+str2.trim();
		return outcome;
	}
	public Integer getIndexOrNull(String str1, char char2) {
		int outcome = str1.indexOf(char2);
		if(outcome == -1) {
			return null;
		}else {
		return outcome;
		}
	}
	public Integer getIndexOrNull(String str1, String str2) {
		int outcome = str1.indexOf(str2);
		if(outcome == -1) {
			return null;
		}else {			
			return outcome;
		}
	}
	public String concatSubstring(String str1, int start, int end, String str2) {
		String outcome = str1.substring(start, end)+str2;
		return outcome;
	}
}
