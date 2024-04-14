import java.util.*;

class Tree {
  int value;
  Tree left, right;
  
  public Tree(int value) {
    this.value = value;
    left = right = null;
  }
}

class KthSmallest {
  static List<Integer> treeList = new ArrayList<>();
  
  static Tree insertToBST(int value, Tree root) {
    // Base case
    if (root == null)
      return new Tree(value);
    
    // Insert node
    if (value <= root.value)
      root.left = insertToBST(value, root.left);
    else
      root.right = insertToBST(value, root.right);
    
    // Return node
    return root;
  }
  
  static void inOrder(Tree root) {
    // Base case
    if (root == null)
      return;
    
    // Traverse Left subtree
    inOrder(root.left);
    
    // Add root
    treeList.add(root.value);
    
    // Traverse right subtree
    inOrder(root.right);
  }
  
  public static void main(String args[]) {
  	Scanner sc = new Scanner(System.in);
      
    // Tree root
    Tree root = null;
    
    // Read inputs and insert to BST
    int a = sc.nextInt();

    // Read list
    while (a != -1) {
      root = insertToBST(a, root);
      a = sc.nextInt();
    }

    // Get in-order traversal of tree
    inOrder(root);
    
    // Read k
    int k = sc.nextInt();
    
    // Output
    System.out.println("Enter the kth value:\nSmallest kth value " + treeList.get(k - 1));
  }
}