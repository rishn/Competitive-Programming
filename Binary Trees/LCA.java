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

class LCA {
  static boolean v1, v2;
  
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
  
  static Tree nodeLoc(Tree node, int n1, int n2) {
    // Base case
    if (node == null)
      return null;
    
    // If v1 is visited
    if (node.value == n1) {
      v1 = true;
      return node;
    }
    
    // If v2 is visited
    if (node.value == n2) {
      v2 = true;
      return node;
    }
    
    // Search for n1 and n2 in children
    Tree left_node = nodeLoc(node.left, n1, n2), right_node = nodeLoc(node.right, n1, n2);
    
    // If left and right subtrees calls return not null, both have n1 or n2, 
    // current node is LCA
    if (left_node != null && right_node != null)
      return node;
    
    // Else non-null child return node has both n1 and n2 and is LCA
    return left_node == null ? right_node : left_node;
  }
  
  public static void main(String args[]) {
  	Scanner sc = new Scanner(System.in);
    
    // Read n1, n2
    int n1 = sc.nextInt(), n2 = sc.nextInt();
    sc.nextLine();
    
    // Read nodes
   	List<Integer> nodes = new ArrayList<>();
    for (String str: sc.nextLine().split(" ")) {
      if (str.equals("N"))
        nodes.add(-1);
      else
	    nodes.add(Integer.parseInt(str));
    }
    
    // Build tree
    Tree root = build(nodes);
    
    // Find lowest common ancestor
    Tree lca = nodeLoc(root, n1, n2);
    
    // Output
    System.out.print(lca != null ? lca.value : -1);
  }
}
