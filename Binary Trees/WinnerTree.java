// WINNER TREE
import java.util.Scanner;

class WinnerTree {
  static int[] winner(int[] candidates, int n) {
    // Declare tree as array of integers
    int[] tree = new int[(int)Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)) + 1) - 1];

    // Fill leaves
    for (int i = 0; i < n; i++)
      tree[n - 1 + i] = candidates[i];

    // Fill winners in internal nodes
    for (int i = n - 2; i >= 0; i--)
      tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);

    // Return built tree
    return tree;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read candidates of elements
    int n = sc.nextInt();
    int[] candidates = new int[n];
    for (int i = 0; i < n; i++)
        candidates[i] = sc.nextInt();

    // Output
    System.out.println(winner(candidates, n)[0]);
  }
}
