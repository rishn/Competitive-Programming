import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class EvenOddIndex {
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
        
        Node ptr = new Node(head.value), new_head = ptr;
        temp = head;
        
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next.next;
            ptr = push(ptr, temp.value);
        }
        
        temp = head.next;
        ptr = push(ptr, temp.value);
        
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next.next;
            ptr = push(ptr, temp.value);
        }
        
        print(new_head);
    }
}

// USING COLLECTION
/*
class EvenOddIndex {
    static void print(LinkedList ll) {
        ll.forEach((i)->System.out.print(i + " "));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        LinkedList<Integer> ll1 = new LinkedList<Integer>(), ll2 = new LinkedList<Integer>();
        
        while (a != -1) {
            ll1.add(a);
            a = sc.nextInt();
        }
        
        for (int i = 0; i < ll1.size(); i += 2)
                ll2.add(ll1.get(i));
        
        for (int i = 1; i < ll1.size(); i += 2)
                ll2.add(ll1.get(i));
        
        print(ll2);  
    }
}
*/
