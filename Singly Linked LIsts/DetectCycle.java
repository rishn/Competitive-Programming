import java.util.Scanner;

// Custom LL class 
class Node {
	int value;
  Node next;
  
  Node(int value) {
  	self.value = value;
    next = NULL;
  }
}

// Public class
class Loop {
	static void initialize(Node head, int n) {
  	Scanner sc = new Scanner(System.in);
    
  	// LL Pointer
    Node head = Node(sc.nextInt()), ptr = head;
    
    // Add inputs to LL
    for (int i = 1; i < n; i++) {
    	ptr.next = Node(sc.nextInt());
      ptr = ptr.next;
    }
  }
  
  static void createCycle(Node head, int a, int b) {
  	// Initialize values
  	int cnta = 0, cntb = 0;
    Node ptr1 = head, ptr2 = head;
    
    // Create cycle at required indices
    while (cnta != a || cntb != b) {
    	ptr1 = ptr1.next();
      ptr2 = ptr2.next();
      cnta++;
      cntb++;
    }
    ptr2.next = ptr1;
  }
  
  static Boolean detectCycle(Node head) {
  	Node fast, slow = head;
    
    // Detect cycle
    while (fast.next != NULL && fast.next.next != NULL) {
    	slow = slow.next;
      fast = fast.next.next;
    	if (fast == slow)
      	return true;
    }
    
    // Cycle not detected
    return false;
  }
  
  public static void main(String[] args) {
    // Read size of LL
    int n = sc.nextInt();
    
    // Read inputs
    Node head;
    initialize(head, n);
    
    // Read index for creating cycle
    int a = sc.nextInt();
    
    // Create cycle in linked list
    createCycle(head, 1, a);
    
    // Output
    System.out.println(detectCycle(head) ? "Cycle detected" : "Cycle not detected");
  }
}
