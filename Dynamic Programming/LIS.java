import java.util.*;

class LIS {
  static int longestIncreasingSubsequences(int[] nums, int n) {
    // Base Case
    if (n == 0)
      return 0;

    // Initialize DP (l) array with 1s
    int[] dp_l = new int[n];
    Arrays.fill(dp_l, 1);

    // Initialize DP (c) array with 1s
    int[] dp_c = new int[n];
    Arrays.fill(dp_c, 1);

    for(int i = 0; i < n; i++)
      for(int j = 0; j < i; j++) {

        // If current element is smaller
        if (nums[i] > nums[j])
          // Compare DP matrix values
          if (dp_l[j] + 1 > dp_l[i]) {
            dp_l[i] = dp_l[j] + 1;
            dp_c[i] = dp_c[j];
          }
          else if (dp_l[j] + 1 == dp_l[i])
            dp_c[i] += dp_c[j];
      }

    // Store the maximum element from DP (l)
    int max_length = 0;
    for(int i : dp_l)
      max_length = Math.max(i, max_length);

    // LIS counter
    int count = 0;

    // Traverse DP (l) and DP (c) simultaneously
    for(int i = 0; i < n; i++)
      // Update the count
      if (dp_l[i] == max_length)
        count += dp_c[i];

    // Return the count of LIS
    return count;
  }

  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    
    // Read array
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    
    // Function Call
    System.out.println(longestIncreasingSubsequences(arr, n));
  }
}
