// VERTICAL TRAVERSAL
import java.util.*;
import java.util.Map.Entry;

// Custom Tree class 
class Tree {
    int value;
    Tree left, right;
    
    Tree(int value) {
        this.value = value;
        left = right = null;
    }
}

class VerticalOrder {
    static Tree build(String[] arr) {
        // Base case
        if (arr[0] == "null" || arr.length == 0)
            return null;
        
        Tree root = new Tree(Integer.parseInt(arr[0]));
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        
        int i = 1;
        while(! q.isEmpty() && i < arr.length) {
            Tree curr = q.poll();
        
            String cval = arr[i];
            if (! cval.equals("null")) {
                curr.left = new Tree(Integer.parseInt(cval));
                q.add(curr.left);
            }
            i++;
            
            if (i < arr.length) {
                cval = arr[i];
                if (! cval.equals("null")) {
                curr.right = new Tree(Integer.parseInt(cval));
                q.add(curr.right);
                }
            }
            i++;
        }
        
        return root;
    }
    
    static void preOrder(Tree root, int i, TreeMap<Integer, Vector<Integer>> m) {
        // Base case
        if (root == null)
            return;
        
        // Get vector at i
        Vector<Integer> g = m.get(i);
        
        // Update vector
        if (g == null) 
            g = new Vector<>();
        g.add(root.value);
        
        // Store curr node in map m
        m.put(i, g);
        
        // Store nodes in left subtree
        preOrder(root.left, i - 1, m);
        
        // Store nodes in right subtree
        preOrder(root.right, i + 1, m);
    }
    
    static void verticalOrder(Tree root) {
        TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
        preOrder(root, 0, m);
        
        for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) {
            for (Integer i : entry.getValue())
                System.out.print(i + " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read inputs
        String[] arr = sc.nextLine().split(" ");
        
        // Build tree
        Tree root = build(arr);
        
        // Output
        verticalOrder(root);
    }
}
