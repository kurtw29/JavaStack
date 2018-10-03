package tries;

public class Trie {
	//Trie starts with root
	public Node root;
	
	//Trie constructor
	public Trie() {
		this.root = new Node();
	}
	
	public void insertWord(String word) {
		//gets the root node;
		Node currentNode = this.root;
		
		//iterates over every character in the word
		for(int i = 0; i < word.length(); i++) {
			//currentLetter is the letter at the iteration
			Character currentLetter = word.charAt(i);
			//check if the current letter is in the map of the current node;
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);
			}
			currentNode = child;
		}
		currentNode.isCompleteWord = true;
	}
	
	//**return true if prefix is in the trie, false otherwise;**	
	public boolean isPrefixValid(String prefix) {
		// declare and assign currentNode = this.root - to keep track of where in trie
		Node currentNode = this.root;
		//iterate through the given prefix, character by character
		for(int i = 0 ; i < prefix.length(); i++) {
			Character currentLetter = prefix.charAt(i);
			// check if the character is in the HashMap of the currentNode
			Node child = currentNode.children.get(currentLetter);
			if(child == null) {
				return false;
			// if character is in the currentNode's HashMap("children") -> update currentNode = children (the Node that the character points at) & repeat
			// if character is not in the currentNode - return false
			}else {
				currentNode = child;
			}			
		}
		//upon completion of iteration - return true;
		return true;
	}
	
	//Return a boolean whether the word is in the trie or not
	public boolean isWordValid(String word) {
		//create currentNode to keep track where in trie
		Node currentNode = this.root;
		//iterate thru the character of the word
		for(int i = 0; i < word.length(); i++) {
			char currentLetter = word.charAt(i);
			//create 'child' as the currentLetter's node & check if currentNode's HashMap ("children") has the current character
			Node child = currentNode.children.get(currentLetter);
			// if child is null (ie letter not found in currentNode's"children") then return false
			if(child == null) {
				return false;
			}else {
				// else true -> update currentNode to character's node (child) and repeat
				currentNode = child;
			}
		}
		// after iterate through the word, return = currentNode.children(isCompleteWord) 
		return currentNode.isCompleteWord;
	}
	
}
