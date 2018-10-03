package tries;
import java.util.HashMap;

public class Node {
	//Node has the following attributes:
	public HashMap<Character, Node> children;
	public boolean isCompleteWord;
	
	//Node constructor
	public Node() {
		this.children = new HashMap<Character, Node>();
		this.isCompleteWord = false;
	}
}
