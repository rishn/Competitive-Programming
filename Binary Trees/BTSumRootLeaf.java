import java.util.*;

class Tree {
  int value;
  Tree left, right;
  
  public Tree(int value) {
    this.value = value;
    left = right = null;
  }
}

class SumRootLeaf {
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
  
  static int solve(Tree root, int sum) {
    if (root == null)
      return 0;

    sum = sum * 10 + root.value;
    if (root.left == null && root.right == null)
      return sum;
   	
	return solve(root.left, sum) + solve(root.right, sum);
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
    Tree root = build(nodes);
    
    // Output
    System.out.println(solve(root, 0));
  }
}