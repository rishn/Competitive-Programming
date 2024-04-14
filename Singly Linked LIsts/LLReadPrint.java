import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LLIO {
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
        
        print(head);    
    }
}

// USING COLLECTION
/*
class LLIO {    
    static void print(LinkedList ll) {
        ll.forEach((i)->System.out.print(i + " "));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        LinkedList<Integer> ll = new LinkedList<>();
        
        while (a != -1) {
            ll.add(a);
            a = sc.nextInt();
        }
        
        print(ll);    
    }
}
*/