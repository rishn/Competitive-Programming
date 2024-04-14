import java.util.Scanner;

class Node {
    int value, min;
    Node next;

    Node(int value, int min, Node next) {
        this.value = value;
        this.min = min;
        this.next = next;
    }
}

class MyStack {
    // Min Stack using LLs
    private Node head;

    public MyStack() {}
    
    public void push(int val) {
		// If stack empty
        if (head == null)
            head = new Node(val, val, null);
        
        // Else, insert at beginning of list
        else
            head = new Node(val, Math.min(val, head.min), head);
    }
    
    public int pop() {
        int v = head.value;

        // Delete first list element (head)
		head = head.next;

        // Return popped element
        return v;
    }
    
    public int peek() {
        // Top element resides at head
        return head.value;
    }
    
    public int getMin() {
        // Minimum resides in head as min
        return head.min;
    }
}

// Driver Code
public class MinStack {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize min stack
		MyStack s = new MyStack();
        
		// Menu
        while (true)
            switch (sc.nextInt()) {
                // Push
                case 1:
                    s.push(sc.nextInt());
                    break;
                
                // Pop
                case 2:
                    System.out.println(s.pop());
                    break;
                
                // Peek
                case 3:
                    System.out.println(s.peek());
                    break;
                
                // Get min
                case 4:
                    System.out.println(s.getMin());
                    break;
                
                // Exit
                case 5:
                    return;
                
                // Invalid
                default:
                    System.out.println("Invalid choice");
                    break;
            }
	}
}
