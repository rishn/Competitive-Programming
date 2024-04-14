// K-ARY HEAP
import java.util.*;

class KAryHeap {
    // Constraint for heap
    int MAX_SIZE = 100;

    static void swap(int[] tree, int i, int j) {
        int temp = tree[i];
        tree[i] = tree[j];
        tree[j] = temp;
    }

    static void restoreUp(int[] tree, int i, int k) {
        // Root of subtree
        int root = (i - 1) / k;

        // Traverse upwards and swap root and current nodes 
        // till root has greater value than current node
        while (root >= 0 && tree[i] > tree[root]) {
            swap(tree, i, root);
            i = root;
            root = (i - 1) / k;
        } 
    }

    static void restoreDown(int[] tree, int i, int n, int k) {
        // Array to store children of node
        int[] child = new int[k];

        while (true) {
            // Get children
            for (int j = 1; j <= k; j++)
                child[j - 1] = (k * i + j) < n ? (k * i + j) : -1;

            // Get max child and index
            int maxChild = Integer.MIN_VALUE, m = -1;
            for (int j = 0; j < k; j++) {
                if (child[j] != -1 && tree[child[j]] > maxChild) {
                    m = child[j];
                    maxChild = tree[child[j]];
                }
            }

            // If current node is leaf
            if (m == -1)
                break;

            // If node is smaller than child, swap them
            if (tree[i] < tree[m])
                swap(tree, i, m);
            
            // Set current node to that of max
            i = m;
        }
    }

    static void build(int[] tree, int n, int k) {
        // Iterate through internal nodes and traverse children and build heap
        for (int i = (n - 1) / k; i >= 0; i--)
            restoreDown(tree, i, n, k);
    }

    static void insert(int[] tree, int value, int n, int k) {
        // Add new node to tree
        tree[n - 1] = value;

        // Restore remaining nodes of heap
        restoreUp(tree, n - 1, k);
    }

    static int extract(int[] tree, int n, int k) {
        // Get root value and assign rightmost leaf to root
        int max = tree[0];
        tree[0] = tree[n - 1];

        // Rebuild heap by traversing children
        restoreDown(tree, 0, n - 1, k);

        // Return root value
        return max;
    }

    static void print(int[] tree, int n) {
        for (int i = 0; i < n; i++)
            System.out.print(tree[i] + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Declare tree as array
        int[] tree = new int[100];

        // Read nodes
        System.out.println("Enter size and nodes:");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();
        
        // Read k
        System.out.print("\nEnter k: ");
        int k = sc.nextInt();

        // Build heap and print
        build(tree, n, k);
        System.out.print("\nBuilt heap: ");
        print(tree, n);

        // Insert element and print heap
        System.out.print("\n\nEnter element to be inserted: ");
        insert(tree, sc.nextInt(), ++n, k);
        System.out.print("\nHeap after insertion: ");
        print(tree, n);
        
        // Extract max from heap
        System.out.println("\n\nExtracted max: " + extract(tree, n, k));
        n--;

        // Print heap
        System.out.print("\nHeap after extraction: ");
        print(tree, n);
        System.out.println();
    }
}
