import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class EvenOdd {
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
        
        Node ptr = new Node(0);
        ptr.next = head;
        
        while (ptr.next != null) {
            if (ptr.next.value % 2 == 0) {
                temp = push(temp, ptr.next.value);
                ptr.next = ptr.next.next;
            }
            
            ptr = ptr.next;
        }
        
        print(head);
    }
}

// USING COLLECTION
/*
class EvenOdd {
    static void print(LinkedList ll) {
        ll.forEach((i)->System.out.print(i + " "));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        LinkedList<Integer> ll = new LinkedList<Integer>();
        
        while (a != -1) {
            ll.add(a);
            a = sc.nextInt();
        }
        
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i) % 2 == 0) {
                ll.add(ll.remove(i));
            }
        }
        
        print(ll);  
    }
}
*/

// INCREASED SPACE COMPLEXITY
/*
class EvenOdd {
	static Node initialize() {
        Scanner sc = new Scanner(System.in);

        // Read size of LL
        int n = sc.nextInt();
        
        // LL Pointer
        Node head = new Node(sc.nextInt()), ptr = head;
        
        // Add inputs to LL
        for (int i = 1; i < n; i++) {
            ptr.next = new Node(sc.nextInt());
            ptr = ptr.next;
        }

        return head;
    }
  
    static Node segregate(Node head) {
        // Base case
        if (head == null || head.next == null)
            return head;
        
        // Create new LL and pointers
        Node new_head = new Node(0), ptr = head, new_ptr = new_head;
        
        // Find even numbers and add to new LL 
        while (ptr != null) {
            if (ptr.value % 2 == 0) {
                new_ptr.next = new Node(ptr.value);
                new_ptr = new_ptr.next;
            }
            ptr = ptr.next;
        }
        
        // Find odd numbers and add to new LL
        ptr = head;
        while (ptr != null) {
            if (ptr.value % 2 != 0) {
                new_ptr.next = new Node(ptr.value);
                new_ptr = new_ptr.next;
            }
            ptr = ptr.next;
        }
        // Return new LL
        return new_head.next;
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
        
        // Read inputs
        Node head = initialize();
        
        // Output
        print(segregate(head));
    }
}
*/
