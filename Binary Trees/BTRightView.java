// RIGHT VIEW
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

class RightView {
  // Function to build tree from level-order array using queue
  static Tree build(List<Integer> nodes) {
    // Empty case
    if (nodes == null || nodes.size() == 0)
      return null;
    
    // Root
    if (nodes.get(0) == -1)
      return null;
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
  
  static void rightView(Tree root) {
   	// Empty case
    if (root == null)
      return;
    
    // Queue
    Queue<Tree> q = new LinkedList<>();
    q.add(root);
    
    while (! q.isEmpty()) {
      // No. of nodes for each level
      int n = q.size();
      
      // Traverse all nodes of current level
      for (int i = 0; i < n; i++) {
        // Current node (front of queue)
        Tree curr = q.remove();
        
        // Print last node of each level
        if (i == n - 1)
          System.out.print(curr.value + " ");
        
        // Add children of current node to queue if not null
        if (curr.left != null)
          q.add(curr.left);
        if (curr.right != null)
          q.add(curr.right);
      }
    }
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
   	List<Integer> nodes = new ArrayList<>();
    
    for (String str: sc.nextLine().split(" "))
      if (str.equals("N"))
        nodes.add(-1);
      else
	      nodes.add(Integer.parseInt(str));
    
    // Build tree
   	Tree root = build(nodes);
    
    // Output
    rightView(root);
  }
}