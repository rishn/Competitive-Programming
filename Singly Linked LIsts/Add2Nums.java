import java.util.*;

class Node {
    int val;
    Node next;

    Node(int val) { 
        this.val = val; 
    }
}

public class Add2Nums {
    static Node add2Nums(Node l1, Node l2) {
        // Digit sum and carry
        int sum = 0, carry = 0;
        
        // Result linked list
        Node l3 = new Node(0), curr = l3;

        // Until any one linked list is traversed entirely
        while (l1 != null && l2 != null) {
            // Find digit sum of values of nodes and carry, update carry
            sum = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;

            // Add new node with digit sum value to result list 
            curr.next = new Node(sum);

            // Move to next nodes
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // Until l1 is traversed entirely
        while (l1 != null) {
            // Find digit sum of node value and carry, update carry
            sum = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;

            // Add new node with digit sum value to result list 
            curr.next = new Node(sum);

            // Move to next nodes
            curr = curr.next;
            l1 = l1.next;
        }

        // Until l2 is traversed entirely
        while (l2 != null) {
            // Find digit sum of node value and carry, update carry
            sum = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;

            // Add new node with digit sum value to result list 
            curr.next = new Node(sum);

            // Move to next nodes
            curr = curr.next;
            l2 = l2.next;
        }

        // If carry is present, add new node with carry as value
        if (carry == 1)
            curr.next = new Node(1);

        // Return linked list
        return l3.next;
    }

    // Function to print list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read lists
        Node l1 = new Node(0), l2 = new Node(0), temp = l1;
        String[] s1 = sc.nextLine().split(" "), s2 = sc.nextLine().split(" ");
        for (String val : s1) {
            temp.next = new Node(Integer.parseInt(val));
            temp = temp.next;
        }
        temp = l2;
        for (String val : s2) {
            temp.next = new Node(Integer.parseInt(val));
            temp = temp.next;
        }

        // Output
        printList(add2Nums(l1.next, l2.next));
    }
}
