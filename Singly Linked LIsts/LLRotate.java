import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class RotateLL {
    static Node push(Node temp, int value) {
        temp.next = new Node(value);
        
        return temp.next;
    }
    
    static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        Node head = null, temp = head;
        
        while (a != -1) {
            if (head == null) {
                head = push(new Node(0), a);
                temp = head;
            }
            else
                temp = push(temp, a);
            a = sc.nextInt();
        }
      
      	System.out.println("Given linked list:");
      	print(head);
      
      	int k = sc.nextInt();
      	for (int i = 0; i < k; i++) {
        	Node tail = head;
          	head = head.next;
          	tail.next = null;
          	temp.next = tail;
          	temp = temp.next;
        }
      	System.out.println("\nRotated Linked list:");
      	print(head);
    }
}