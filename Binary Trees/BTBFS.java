// BT BFS
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

class BTBFS {
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

    static void BFS(Tree root) {
        // Initialize queue with root
        Queue<Tree> q = new LinkedList<Tree>();
        q.add(root);
        
        while (! q.isEmpty()) {
            // Remove node from queue and print value
            Tree temp = q.poll();
            System.out.print(temp.value + " ");
 
            // Enqueue left child
            if (temp.left != null)
                q.add(temp.left);
 
            // Enqueue right child
            if (temp.right != null)
                q.add(temp.right);
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Since BFS is the same as level order traversal
        // and the nodes are input in level order, we can
        // print the input array directly
        /*
        for (String str : sc.nextLine().split(" "))
            if (! str.equals("N"))
                System.out.print(str + " ")
        */

        // Read nodes
        List<Integer> nodes = new ArrayList<>();
        for (String str : sc.nextLine().split(" "))
            if (str.equals("N"))
                nodes.add(-1);
            else
                nodes.add(Integer.parseInt(str));
        
        // Build tree
        Tree root = build(nodes);
        
        // Output
        BFS(root);
        System.out.println();
    }
}