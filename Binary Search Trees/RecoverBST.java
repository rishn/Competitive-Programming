// RECOVER BST
import java.util.*;

// Custom Tree class 
class Tree {
    int value;
    Tree left, right;
    
    Tree(int value) {
        this.value = value;
        left = right = null;
    }
}

// Public class
class RecoverBST {
    static Tree build(String[] arr) {
        // Base case
        if (arr[0] == "null" || arr.length == 0)
            return null;
            
        Tree root = new Tree(Integer.parseInt(arr[0]));
        Queue<Tree> q = new LinkedList<Tree>();
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
    
    static void recover(Tree root) {
        // Initialize stack and pointers
        Stack<Tree> stk = new Stack<>();
        Tree curr = root, processed = null;
        Tree[] swapped = new Tree[2];
        
        // Process
        while (! stk.isEmpty() || curr != null) {
            // Push elements into stack
            while (curr != null) {
                stk.push(curr);
                curr = curr.left;
            }   
        
            // Pop element and assign to pointer
            curr = stk.pop();
            
            if (processed != null && processed.value > curr.value) {
                swapped[1] = curr;
                if (swapped[0] ==  null)
                    swapped[0] = processed;
                else
                    break;
            }
            processed = curr;
            curr = curr.right;
        }
        
        // Swap values in swapped array
        int tmp = swapped[0].value;
        swapped[0].value = swapped[1].value;
        swapped[1].value = tmp;
    }
    
    static void inOrder(Tree node) {
        // Base case
        if (node == null)
            return;
        
        inOrder(node.left);	// Left child
        System.out.print(node.value + " ");	// Parent
        inOrder(node.right);	// Right child
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read inputs
        String[] arr = sc.nextLine().split(" ");
        
        // Build tree
        Tree root = build(arr);
        
        // Recover BST
        recover(root);
        
        // Output
        inOrder(root);
    }
}
