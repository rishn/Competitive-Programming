import java.util.*;

class Node {
    int value;
    Node next;
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class Tree {
  int value;
  Tree left, right;
  
  public Tree() {}
  
  public Tree(int value) {
    this.value = value;
    left = right = null;
  }
}

class BSTFromSorted {
  static Tree sortedListToBST(Node head) {
    // Base case
    if (head == null) 
      return null;

    // Pointers
    Node slow = head, fast = head, prev = null;

    // Use two pointers to split the linked list into halves
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    // Create a new node for the middle element and make it the root of the BST
    Tree root = new Tree(slow.value);

    // If the linked list has only one element, return the root
    if (slow == head) 
      return root;

    // Split the linked list into two halves
    prev.next = null;                           
    
    // Recursively construct the left and right subtrees of the root        
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    
    // Return root
    return root;
  }
  
  static void preOrder(Tree root) {
    // Base case
    if (root == null)
      return;
    
    // Print root
    System.out.print(root.value + " ");
    
    // Print left subtree
	  preOrder(root.left);
    
    // Print right subtree
	  preOrder(root.right);
  }
  
  public static void main(String args[]) {
  	Scanner sc = new Scanner(System.in);
    
    // No. of lists
    int n = sc.nextInt();
    
    for (int t = 0; t < n; t++) {
      // Size of list
      int m = sc.nextInt();
      
      // Read list
      Node head = new Node(0), ptr = head;
      for (int i = 0; i < m; i++) {
        ptr.next = new Node(sc.nextInt());
        ptr = ptr.next;
      }
      
      // Convert list to BST
      Tree root = sortedListToBST(head.next);
      
      // Output
      preOrder(root);
      System.out.println();
    }
  }
}


// ARRAY AS INPUT
/*
class BSTFromSorted {
  static Tree sortedListToBST(int[] l, int s, int e) {
    // Traversal complete
    if (s > e)
      return null;
    
    // Middle of subarray
    int m = s + (e - s) / 2;
    
    // Insert subarray middle to tree
    Tree root = new Tree(l[m]);
    
    // Left and right recursions for two halves of subarray
    root.left = sortedListToBST(l, s, m - 1);
    root.right = sortedListToBST(l, m + 1, e);
    
    // Return node
    return root;
  }
  
  static void preOrder(Tree root) {
    // Base case
    if (root == null)
      return;
    
    // Print root
    System.out.print(root.value + " ");
    
    // Print left subtree
	  preOrder(root.left);
    
    // Print right subtree
	  preOrder(root.right);
  }
  
  public static void main(String args[]) {
  	Scanner sc = new Scanner(System.in);
    
    // No. of lists
    int n = sc.nextInt();
    
    for (int t = 0; t < n; t++) {
      // Size of list
      int m = sc.nextInt();
      
      // Read list
      int[] arr = new int[m];
      for (int i = 0; i < m; i++)
      	arr[i] = sc.nextInt();
      
      Tree root = sortedListToBST(arr, 0, m - 1);
      
      // Output
      preOrder(root);
      System.out.println();
    }
  }
}
*/