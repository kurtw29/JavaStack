package datastructure;

public class DLLTest {
	public static void main(String[] args) {
		DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        Node n7 = new Node(120);
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);

        dll.printValuesForward();
        System.out.println("\nAssignment starts here: \n");
        dll.pop();
        dll.printValuesBackward();
        dll.pop();
        System.out.println("\n");
        dll.printValuesForward();
        dll.contains(60);
        System.out.println(dll.size()+"\n");
        dll.insertAt(n7, 4);
        dll.printValuesForward();
        
	}
}
