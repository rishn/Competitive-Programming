import java.util.*;

class Tree {
  int value;
  Tree left, right;
  
  public Tree() {}
  
  public Tree(int value) {
    this.value = value;
    left = right = null;
  }
}

class Flatten {
  static Tree root;
  
  // Function to build tree from level-order array using queue
  static Tree build(List<Integer> nodes) {
    // Empty case
    if (nodes == null || nodes.size() == 0 || nodes.get(0) == -1)
      return null;
    
    // Root
    Tree root = new Tree(nodes.get(0));
    
    // Queue
    Queue<Tree> q = new LinkedList<>();
    q.add(root);
    
    // Iterator
    int i = 1;
    while (i < nodes.size()) {
      // Dequeue current node
      Tree curr = q.remove();
      
      // Add left child to current node
      if (i < nodes.size() && nodes.get(i) != -1) {
        curr.left = new Tree(nodes.get(i));
        q.add(curr.left);
      }
      i++;
      
      // Add right child to current node
      if (i < nodes.size() && nodes.get(i) != -1) {
        curr.right = new Tree(nodes.get(i));
        q.add(curr.right);
      }
      i++;
    }
    
    // Return root of built tree
    return root;
  }
  
  static void flatten(Tree node) {
    if (node == null || (node.left == null && node.right == null))
      return;
    
    if (node.left != null) {
      // Left recursion
      flatten(node.left);
      
      // Store right child in temp node and assign left to right child
      Tree temp = node.right;
      node.right = node.left;
      
      // Make left child null
      node.left = null;
      
      // Add original right child to rightmost position of right subtree of curr right child
      Tree curr = node.right;
      while (curr.right != null) {
        curr = curr.right;
      }
      curr.right = temp;
    }
    
    // Right recursion
    flatten(node.right);
  }
  
  public static void main(String args[]) {
  	Scanner sc = new Scanner(System.in);
    
    // Read nodes
   	List<Integer> nodes = new ArrayList<>();
    for (String str: sc.nextLine().split(" ")) {
      if (str.equals("N"))
        nodes.add(-1);
      else
	    nodes.add(Integer.parseInt(str));
    }
    
    // Build tree
    root = build(nodes);
    
    // Flatten tree
    flatten(root);
    
    // Print tree
    while (root != null) {
      System.out.print(root.value + " ");
      root = root.right;
    }
  }
}