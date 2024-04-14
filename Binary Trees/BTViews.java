// BT VIEWS
import java.util.*;
import java.util.Map.Entry;

// Custom Tree class 
class Tree {
    int value, d;
    Tree left, right;
    
    Tree(int value) {
        this.value = value;
        d = Integer.MAX_VALUE;
        left = right = null;
    }
}

// Custom Queue class
class Que {
    int d;
    Tree node;
    Que(int d, Tree node) {
        this.d = d;
        this.node = node;
    }
}

// Public class
class View {
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
    
    // Right view
    static void rightView(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Initialize queue
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        
        while (! q.isEmpty()) {
            // No. of nodes for each level
            int n = q.size();
            
            // Traverse all nodes of current level
            for (int i = 0; i < n; i++) {
                Tree curr = q.remove();
                        
                // If rear of queue, print right view element
                if (i == n - 1)
                    System.out.print(curr.value + " ");
                
                // Add left subtree to queue 
                if (curr.left != null)
                    q.add(curr.left);
                
                // Add right subtree to queue
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }
        
    // Left view
    static void leftView(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Initialize queue
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        
        while (! q.isEmpty()) {
            // No. of nodes for each level
            int n = q.size();
            
            // Traverse all nodes of current level
            for (int i = 0; i < n; i++) {
                Tree curr = q.remove();
                        
                // If front of queue, print left view element
                if (i == 0)
                    System.out.print(curr.value + " ");
                
                // Add left subtree to queue 
                if (curr.left != null)
                    q.add(curr.left);
                
                // Add right subtree to queue
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
    }
    
    // Top View
    static void topView(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Initialize queue
        Queue<Que> q = new LinkedList<>();
        q.add(new Que(0, root));
        
        // Initialize map
        Map<Integer, Integer> m = new HashMap<>();
        int min = 0, max = 0;
        
        while (! q.isEmpty()) {
            Que curr = q.poll();
            
            // Add depth to map if not present
            if (! m.containsKey(curr.d))
                m.put(curr.d, curr.node.value);
            
            // Add left subtree to queue 
            if (curr.node.left != null) {
                min = Math.min(min, curr.d - 1);
                q.add(new Que(curr.d - 1, curr.node.left));
            }

            // Add right subtree to queue
            if (curr.node.right != null) {
                max = Math.max(max, curr.d + 1);
                q.add(new Que(curr.d + 1, curr.node.right));
            }
        }

        // Print view
        for (; min <= max; min++)
            System.out.print(m.get(min) + " ");
    }
    
    // Bottom View
    static void bottomView(Tree root) {
        // Base case
        if (root == null)
            return;
        
        // Initialize queue and map
        Queue<Tree> q = new LinkedList<>();
        Map<Integer, Integer> m = new TreeMap<>();
        root.d = 0;
        q.add(root);
        
        while (! q.isEmpty()) {
            Tree curr = q.remove();
            m.put(curr.d, curr.value);
            
            // Add left subtree to queue 
            if (curr.left != null) {
                curr.left.d = curr.d - 1;
                q.add(curr.left);
            }

            // Add right subtree to queue
            if (curr.right != null) {
                curr.right.d = curr.d + 1;
                q.add(curr.right);
            }
        }

        // Print view
        Set<Entry<Integer, Integer>> s = m.entrySet();
        Iterator <Entry<Integer, Integer>> it = s.iterator();
        while (it.hasNext()) 
            System.out.print(it.next().getValue() + " ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read inputs
        String[] arr = sc.nextLine().split(" ");
        
        // Build tree
        Tree root = build(arr);
        
        // Output
        rightView(root);
        System.out.println();
        leftView(root);
        System.out.println();
        topView(root);
        System.out.println();
        bottomView(root);
        System.out.println();
    }
}