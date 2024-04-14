import java.util.Scanner;

// Custom DLL class 
class Node {
    int value, p;
    Node prev, next;
    
    Node(int value, int p) {
        self.value = value;
        self.p = p;
    }
}

// Public class
class PriQueue {
	private static Node head = null;
  
    static void enqueue(int v, int p) {
        // Create node
        Node node = Node(v, p);
        
        // Empty LL
        if (head == null) {
            head = node;
            return;
        }
        
        // Push new node into DLL
        Node ptr = head, parent = null;
        while (ptr != null && ptr.p >= p) {
            parent = ptr;
            ptr = ptr.next;
        }
        if (parent == null) {
            node.next = head;
            head.prev = node;
            head = node;
        }
        else if (ptr == null) {
            parent.next = node;
            node.prev = parent;
        }
        else {
            parent.next = node;
            node.prev = parent;
            node.next = ptr;
            ptr.prev = node;
        }
    }
    
    static void front() {
        // Empty LL
        if (head == null)
            return -1;
        
        return head.value;			// Front of queue
    }
    
    static int dequeue() {
        // Empty LL
        if (head == null)
            return - 1;
        
        int curr = head.value;	    // Front of queue
        head = head.next;
        
        // Non-empty DLL
        if (head != null)
        head.prev = null;
        
        return curr;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size of LL
        int x, q, n = sc.nextInt();
        
        // Read inputs
        for (int i = 0; i < n; i++)
        switch (sc.nextInt()) {
            // Push 
            case 1:
                enqueue(sc.nextInt(), sc.nextInt());
                break;
            
            // Pop
            case 2:
                System.out.println(dequeue());
                break;
            
            // Peek
            case 3:
                System.out.println(front());
                break;
            
            // Invalid
            default:
                System.println("Invalid");
                sc.nextLine();
                break;
        }
    }
}
