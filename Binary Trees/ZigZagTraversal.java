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

class ZigZag {
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
  
  static List<Integer> zigZagLevelOrder(Tree root) {
    // Base case
    if (root == null)
      return null;
    
    // Declare result list
    List<Integer> res = new ArrayList<>();
    
    // Declare queue
    Queue<Tree> q = new LinkedList<>();
    q.add(root);
    
    // Direction of traversal across level
    boolean lToR = true;
    
    // Run loop till queue is empty, every iteration represents new tree level from root
    while (! q.isEmpty()) {
      // Store current size of queue
      int size = q.size();
      
      // Temporary list to be added to result list depending on insertion method
      List<Integer> temp = new ArrayList<>();
      
      // Add every element in queue to temp list and replace with children
      for (int i = 0; i < size; i++) {
        Tree curr = q.remove();
        if (curr.left != null)
          q.add(curr.left);
        if (curr.right != null)
          q.add(curr.right);
        temp.add(curr.value);
      }
      
      // Right to left insertion (zig-zag)
      if (! lToR)
        Collections.reverse(temp);
      
      // Add elements to result list from temp list
      for (int i : temp)
        res.add(i);
      
      // For new level, change order of insertion
      lToR = ! lToR;
    }
    
    // Return result
    return res;
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
    List<Integer> zigZag = zigZagLevelOrder(root);
    for (int i : zigZag)
      System.out.print(i + " ");
  }
}
