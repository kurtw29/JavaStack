package datastructure;

public class DLL {
	public Node head;
	public Node tail;
	
	public DLL() {
		this.head = null;
		this.tail = null;
	}
	
	public void push(Node newNode) {
		if(this.head == null) {
			this.head = newNode;
			this.tail = newNode;
			return;
		}
		
		Node lastNode = this.tail;
		lastNode.next = newNode;
		newNode.previous = lastNode;
		this.tail = newNode;
	}
	
	public void printValuesForward() {
		Node current = this.head;
		while(current != null) {
			System.out.println(current.value);
			current = current.next;
		}
	}
	
	void printValuesBackward() {
		Node current = this.tail;
		while(current != this.head) {
			System.out.println(current.value);
			current = current.previous;
		}
	}
	
	Node pop() {
		Node lastNode = this.tail;
		this.tail = lastNode.previous;
		lastNode.previous.next = null;
		return lastNode;
	}
	
	boolean contains(Integer value) {
		Node current = this.head;
		while(current != null) {
			if(current.value == value) {
				System.out.println("True");
				return true;
			}
			current = current.next;
		}
		System.out.println("False");
		return false;
	}
	
	int size() {
		Node current = this.head;
		if(this.head == null) {
			return 0;
		}
		int counter = 0;
		while(current != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}
	
	void insertAt(Node newNode, int index) {
		if(index == this.size()) {
			newNode.previous = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
		}else
		if(index == 0) {
			newNode.next = this.head;
			this.head.previous = newNode;
			this.head = newNode;
		}else if(index > this.size()) {
			System.out.println("invalid index argument");
		}else {
			int counter = 0;
			Node current = this.head;
			while(current != null) {
				current = current.next;
				counter++;
				if(counter == index) {
					current.previous.next = newNode;
					newNode.previous = current.previous;
					newNode.next = current;
					current.previous = newNode;
				}
			}
			
		}
	}
}
