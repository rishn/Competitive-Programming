import java.util.Scanner;

class KnapSack {
  static int knapSack(double W, double[] wt, int[] p, int n) {
    // Base case - zero capacity or all items checked
    if (n == 0 || W == 0)
      return 0;
    
    // If nth item is heavier than knapsack capacity, move to different item
    if (wt[n - 1] > W)
      return knapSack(W, wt, p, n - 1);
      
    // Else, return max of profit with nth item included and profit without nth item
    else
      return Math.max(p[n - 1] + knapSack(W - wt[n - 1], wt, p, n - 1), 
                      knapSack(W, wt, p, n - 1));
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read profits
    int n = sc.nextInt();
    int[] p = new int[n];
    for (int i = 0; i < n; i++)
      p[i] = sc.nextInt();
    
    // Read weights
    n = sc.nextInt();
    double[] wt = new double[n];
    for (int i = 0; i < n; i++)
      wt[i] = sc.nextDouble();
    
    // Read capacity
    double W = sc.nextInt();
    
    // Output
    System.out.println(knapSack(W, wt, p, n));
  }
}
