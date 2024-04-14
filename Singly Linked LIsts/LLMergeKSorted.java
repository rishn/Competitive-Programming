import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
    }
}

class MergeKSorted {
  // Function that merges two sorted lists
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

  // Recursive function to merge k lists
  static Node mergeKLists(Node[] lists, int s, int e) {
    // Base case (no more lists to merge)
    if (s == e)
      return lists[s];
    
    // If one more list left to merge
    if (s + 1 == e)
      return merge2Lists(lists[s], lists[e]);

    // Merge left half of subarray and right half of subarray and merge them together
    int m = s + (e - s) / 2;
    return merge2Lists(mergeKLists(lists, s, m), mergeKLists(lists, m + 1, e));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read no. of lists
    int n = Integer.parseInt(sc.nextLine());

    // Base case
    if (n == 0)
      return;
    
    // Read array of lists
    Node[] lists = new Node[n];
    for (int i = 0; i < n; i++) {
      String[] str = sc.nextLine().split(" ");
      lists[i] = new Node(0);
      Node ptr = lists[i];
      for (String j : str)
        if (! j.equals("-1")) {
          ptr.next = new Node(Integer.parseInt(j));
          ptr = ptr.next;
        }
      lists[i] = lists[i].next;
    }

    // Output
    Node res = mergeKLists(lists, 0, n - 1);
    while (res != null) {
      System.out.print(res.value + " ");
      res = res.next;
    }
    System.out.println();
  }
}

// PERSONAL ATTEMPT (USING COLLECTIONS)
/*
class MergeKSorted {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read no. of lists
    int n = Integer.parseInt(sc.nextLine()), t = 0;
    
    // LL array
    LinkedList<Integer>[] ll = new LinkedList[n];
    LinkedList<Integer> res = new LinkedList<>();
    
    for (int i = 0; i < n; i++) {
      String[] str = sc.nextLine().split(" ");
      ll[i] = new LinkedList<>();
      for (String j : str)
        if (! j.equals("-1")) {
          ll[i].add(Integer.parseInt(j));
          t++;
        }
  	}
    
    for (int i = 0; i < t; i++) {
      int min = Integer.MAX_VALUE, index = -1;
      for (int j = 0; j < n; j++) 
        if (ll[j].size() > 0 && min > ll[j].get(0)) {
          min = ll[j].get(0);
          index = j;
        }
      if (index == -1)
        break;
      res.add(ll[index].remove(0)); 
    }
    
    res.forEach((i)->System.out.print(i + " "));
  }
}
*/