import java.util.Scanner;

// Custom DLL class 
class Node {
    int value;
    Node prev, next;
    
    Node(int value, Node prev) {
        this.value = value;
        next = null;
        this.prev = prev;
    }
}

// Public class
class MergeSortDLL {
    
    // Split DLL
    static Node split(Node head) {
        Node fast = head, slow = head;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        Node temp = slow.next;
        slow.next = null;
        return temp;
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
    
    static Node mergeSort(Node head) {
        // Base case
        if (head == null || head.next == null)
            return head;
        
        // Split the list
        Node new_node = split(head);
        
        // Recursive call with new list parameters
        head = mergeSort(head);
        new_node = mergeSort(new_node);
        
        // Merge lists after sorting
        return merge(head, new_node);
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
        head = new Node(sc.nextInt(), null);
        Node ptr = head;
        for (int i = 0; i < n; i++) 
            ptr.next = new Node(sc.nextInt(), ptr);
        
        // Sort and print
        print(mergeSort(head));
    }
}