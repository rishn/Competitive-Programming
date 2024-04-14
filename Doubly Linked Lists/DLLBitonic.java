import java.util.Scanner;

// Custom DLL class 
class Node {
    int value;
    Node prev, next;
    
    Node(int value, Node next) {
        this.value = value;
        prev = null;
        this.next = next;
    }
}

// Public class
class Bitonic {
    static Node push(Node head, int value) {
        // Create new node
        Node new_node = new Node(value, head);

        // Update head pointer
        if (head != null)
            head.prev = new_node;
        head = new_node;
        return head;
    }
  
    static Node reverse(Node head) {
        // Pointers
        Node temp = null, curr = head;
        
        // Reverse list
        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        
        // Check for empty list
        if (temp != null)
            head = temp.prev;
        
        // New head pointer
        return head;
    }
    
    static Node merge(Node a, Node b) {
        // Base case
        if (a == null)
            return b;
        if (b == null)
            return a;
        
        // Find the smaller value
        if (a.value < b.value) {
            a.next = merge(a.next, b);
            a.next.prev = a;
            a.prev = null;
            return a;
        }
        else {
            b.next = merge(a, b.next);
            b.next.prev = a;
            b.prev = null;
            return b;
        }
    }
    
    static Node sort(Node head) {
        // Base case
        if (head == null || head.next == null)
            return head;
        
        // Process
        Node curr = head.next;
        while (curr != null) {
            // Find node where prev node has greater value
            if (curr.value < curr.prev.value)
                break;
                
            curr = curr.next;
        }
        
        // If end of list is reached, list is already sorted
        if (curr == null)
            return head;
        
        // Split the list
        curr.prev.next = null;
        curr.prev = null;

        // Reverse the second list
        curr = reverse(curr);
        
        // Merge new lists again after sorting
        return merge(head, curr);
    }
    
    // Print DLL
    static void print(Node head) {
        // Empty list
        if (head == null)
            System.out.println("Empty list");
        
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read size of LL
        int n = sc.nextInt();

        // Read inputs
        Node head = null;
        for (int i = 0; i < n; i++) 
            head = push(head, sc.nextInt());
        
        // Sort and print
        print(sort(head));
    }
}



