// BOUNDARY TRAVERSAL
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

class Boundary {
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

    static void leaves(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Left child
        leaves(root.left);

        // Print value if leaf node
        if (root.left == null && root.right == null)
            System.out.print(root.value + " ");
        
        // Right child
        leaves(root.right);
    }

    static void leftBoundary(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Traverse left subtree in top-down manner
        if (root.left != null) {
            System.out.print(root.value + " ");
            leftBoundary(root.left);
        }

        // If no left subtree, traverse right subtree
        else if (root.right != null) {
            System.out.print(root.value + " ");
            leftBoundary(root.right);
        }
    }

    static void rightBoundary(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Traverse right subtree in top-down manner
        if (root.right != null) {
            rightBoundary(root.right);
            System.out.print(root.value + " ");
        }

        // If no right subtree, traverse left subtree
        else if (root.left != null) {
            rightBoundary(root.left);
            System.out.print(root.value + " ");
        }
    }

    static void boundary(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Print value
        System.out.print(root.value + " ");

        // Traverse left boundary (top-down)
        leftBoundary(root.left);

        // Print leaf nodes
        leaves(root.left);
        leaves(root.right);

        // Traverse right boundary (bottom-up)
        rightBoundary(root.right);
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
        boundary(root);
        System.out.println();
    }
}