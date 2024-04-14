import java.util.*;

class Node {
    int val;
    Node next;

    Node() {}

    Node(int val) { this.val = val; }

    Node(int val, Node next) { this.val = val; this.next = next; }
}

class Solution {
    static int getNumber(Node head) {
        int dec = 1, num = 0;

        while (head.next != null) {
            num += head.val * dec;

            head = head.next;
        }

        return num;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        int len = 0, result = getNumber(l1) + getNumber(l2), temp = result;

        while (temp > 0) {
            temp /= 10;
            len++;
        }

        Node head = new Node(result % (int)Math.pow(10, len)), t = head;

        while (len != 0)
            t = new Node(result % (int)Math.pow(10, --len), t);

        return head;
    }
}
