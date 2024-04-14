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

class ValidateBST {
  static List<Integer> treeList = new ArrayList<>();
  
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
    
    // Read number of nodes
    int n = sc.nextInt();
    
    // Read nodes and insert to list
    List<Integer> nodes = new ArrayList<>();
    for (int i = 0; i < n; i++)
      nodes.add(sc.nextInt());
      
    // Build tree
    Tree root = build(nodes);
    
    // Get in-order traversal of tree
    inOrder(root);
    
    // Check if in-order traversal is in ascending order
    for (int i = 1; i < n; i++)
      // If not, tree is not BST
      if (treeList.get(i) < treeList.get(i - 1)) {
        System.out.println("False");
        return;
      }
    
    // If yes, tree is BST
    System.out.println("True");
  }
}