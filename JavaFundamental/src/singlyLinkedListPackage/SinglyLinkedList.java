package singlyLinkedListPackage;

public class SinglyLinkedList {
	public Node head;
	public SinglyLinkedList() {
		this.head = null;
	}
	public void add(int value) {
		Node newNode = new Node(value);
		if(this.head == null) {
			this.head = newNode;
			head = newNode;
		}else {
			Node runner = head;
			while(runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}
	
	// remove node from the end of the list;
	public void remove() {
		if(head == null) {
		}else {
			Node runner = head;
			while(runner.next != null && runner.next.next != null) {
				runner = runner.next;
			}
			runner.next = null;
		}
	}
	
	public void printValues() {
		if(this.head == null) {
			System.out.println("null");
		}else{
			System.out.println(this.head.value);
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
				System.out.println(runner.value);
			}
		}
	}
	
	public Node find(int value) {
		if(this.head == null) {
			return null;
		}else {
			if(this.head.value == value) {
				return this.head;	
			}
			Node runner = this.head;
			while(runner.next != null) {
				runner = runner.next;
				if(runner.value == value) {
					return runner;
				}
			}
			return null;
		}
	}
	
	public void removeAt(int value) {
		if(this.head == null) {
			System.out.println("Not values to remove");
		}else {
			int counter = 0;
			if(value == 0) {
				this.head = null;
			}
			Node runner = this.head;
			while(runner.next != null) {
				counter ++;
				if(counter == value) {
					runner = runner.next.next;
				}else {
				runner = runner.next;
				}
			}
		}
	}
}


//	public void remove(int value) {
//		if(this.head == null) {
//			System.out.println("No node to remove");
//		}else {
//			if(head.value == value && head.next != null) {
//				head = head.next;
//			}
//			else if(head.value == value && head.next == null) {
//				head = null;
//			} else {
//				Node runner = head;
//				while(runner.next != null) {
//					if(runner.next.value == value) {
//						runner.next = runner.next.next;
//					}
//					runner = runner.next;
//				}
//			}
//		}
//	}