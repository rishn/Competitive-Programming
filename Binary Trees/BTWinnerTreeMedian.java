// WINNER TREE MEDIAN OF K SORTED ARRAYS
import java.util.*;

class WinnerTreeMedian {
  static int[] build(LinkedList<Integer>[] lists, int n) {
    // Declare tree as array of integers
    int[] tree = new int[(int)Math.pow(2, Math.ceil(Math.log(n + 1) / Math.log(2)) + 1) - 1];

    // Fill leaves
    for (int i = 0; i < n; i++)
      tree[n + i] = lists[i].peek();
    
    // Rightmost leaf has max value
    tree[2 * n] = Integer.MAX_VALUE;

    // Fill winners in internal nodes
    for (int i = n - 1; i >= 0; i--)
      tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);

    // Return built tree
    return tree;
  }

  static int[] update(int[] tree, int value, int i) {
    // Update leaf
    tree[i] = value;

    // Update internal nodes
    while (i > 0) {
      i = (i - 1) / 2;
      tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
    }
    
    // Return tree
    return tree;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read sorted lists and find total number of elements
    int n = Integer.parseInt(sc.nextLine()), total = 0;
    LinkedList<Integer>[] lists = new LinkedList[n];
    for (int i = 0; i < n; i++) {
      lists[i] = new LinkedList();
      for (String j : sc.nextLine().split(" ")) {
          lists[i].add(Integer.parseInt(j));
          total++;
      }
    }
    
    // Find median position and index pointing to list
    int median = (total + 1) / 2, index = n - 1;

    // Build tree
    int[] tree = build(lists, n);
    
    // Update winner after median tournaments
    for (int i = 0; i < median; i++) {
      // Update tree
      tree = update(tree, lists[index].peek(), n + index);

      // Find list of winner and update index and list
      for (int j = 0; j < n; j++)
        if (tree[0] == lists[j].peek()) {
          lists[j].remove();
          index = j;
          break;
        }
    }

    // Output
    System.out.println(tree[0]);
  }
}