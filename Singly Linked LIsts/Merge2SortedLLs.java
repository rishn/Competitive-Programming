import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
    }
}

class Merge2Sorted {
  static Node merge2Lists(Node l1, Node l2) {
    // Base case
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;
    
    // Merged list and pointer
    Node head = new Node(0), ptr = head;
    
    // Till one of the lists is traversed entirely
    while (l1 != null && l2 != null) {
      // If first list's pointed value is smaller, assign the node to pointer and traverse to next node
      if (l1.value <= l2.value) {
        ptr.next = l1;
        l1 = l1.next;
      }

      // If second list's pointed value is smaller, assign the node to pointer and traverse to next node
      else {
        ptr.next = l2;
        l2 = l2.next;
      }

      ptr = ptr.next;
    }
    
    // Assign remaining untraversed list to next of pointer
    ptr.next = (l1 != null) ? l1 : l2;
    
    // Return list
    return head.next;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Linked list and pointer declaration
    Node l1 = new Node(0), l2 = new Node(0), p1 = l1, p2 = l2;

    // Read first list
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      p1.next = new Node(sc.nextInt());
      p1 = p1.next;
    }

    // Read second list
    int m = sc.nextInt();
    for (int i = 0; i < m; i++){
      p2.next = new Node(sc.nextInt());
      p2 = p2.next;
    }

    // Output
    Node res = merge2Lists(l1.next, l2.next);
    while (res != null) {
      System.out.print(res.value + " ");
      res = res.next;
    }
    System.out.println();
  }
}

// USING COLLECTIONS
/*
class Merge2Sorted {
  public static void main(String args[]) {
  	Scanner sc = new Scanner(System.in);
    
    // Linked list declaration
    LinkedList<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>(),
   	  l3 = new LinkedList<>();
    
    // Read LL1
    int n = sc.nextInt();
    for (int i = 0; i < n; i++)
      l1.add(sc.nextInt());
    
    // Read LL2
    int m = sc.nextInt();
    for (int i = 0; i < m; i++)
      l2.add(sc.nextInt());
    
    // Get sorted merged list
    int i = 0, j = 0;
    while (i < n && j < m)
      if (l1.get(i) < l2.get(j))
        l3.add(l1.get(i++));
      else
        l3.add(l2.get(j++));
    
    // Add remaining elements
    while (i < n)
    	l3.add(l1.get(i++));
    while (j < m)
    	l3.add(l2.get(j++));
    
    // Output
    for (int e : l3)
      System.out.print(e + "->");
    System.out.println("NULL");
  }
}
*/
