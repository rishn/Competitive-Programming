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

class BSTDiameter {
  // Function to build tree from level-order array using queue
  static Tree build(List<Integer> nodes) {
    // Empty case
    if (nodes == null || nodes.isEmpty())
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
      if (i < nodes.size() && curr.value > nodes.get(i)) {
        curr.left = new Tree(nodes.get(i++));
        q.add(curr.left);
      }
      
      // Add right child to current node
      if (i < nodes.size() && curr.value <= nodes.get(i)) {
        curr.right = new Tree(nodes.get(i++));
        q.add(curr.right);
      }
    }
    
    // Return root of built tree
    return root;
  }
  
  static int height(Tree root) {
   if (root == null)
     return 0;
   
   return 1 + Math.max(height(root.left), height(root.right));
  }
  
  static int diameter(Tree root) {
    if (root == null)
      return 0;
    
    int lh = height(root.left), rh = height(root.right),
    	ld = diameter(root.left), rd = diameter(root.left);
    
    return Math.max(lh + rh + 1, Math.max(ld, rd));
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
   	List<Integer> nodes = new ArrayList<>();
    int a = sc.nextInt();
    
    while (a != -1) {
      nodes.add(a);
      
      a = sc.nextInt();
   	}
    
    // Build tree
   	Tree root = build(nodes);
    
    // Output
    System.out.println("Diameter of the given binary tree is " + diameter(root));
  }
}
