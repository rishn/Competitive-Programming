// HEAP SORT
import java.util.Scanner;

class HeapSort {
    static void heapify(int[] tree, int i, int n) {
        // Max, left and right child indices
        int m = i, l = 2 * i + 1, r = 2 * i + 2; 

        // Check if left child is greater
        if (l < n && tree[l] > tree[m])
            m = l;
        
        // Check if right child is greater
        if (r < n && tree[r] > tree[m])
            m = r;

        // If max is not at root
        if (m != i) {
            // Swap child and root
            int temp = tree[i];
            tree[i] = tree[m];
            tree[m] = temp;

            // Recursively heapify the affected subtree
            heapify(tree, m, n);
        }
    }

    static void heapSort(int[] tree, int n) {
        // Build heap - iterate through internal nodes
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(tree, i, n);
        
        // Extract elements from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = tree[i];
            tree[i] = tree[0];
            tree[0] = temp;

            // Heapify the reduced heap
            heapify(tree, 0, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read nodes
        int n = sc.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++)
            tree[i] = sc.nextInt();
        
        heapSort(tree, n);

        // Output
        for (int i : tree)
            System.out.print(i + " ");
        System.out.println();
    }
}
