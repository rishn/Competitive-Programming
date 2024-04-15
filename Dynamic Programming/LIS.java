import java.util.*;

class LIS {
    public int longestIncreasingSubsequence(int[] nums) {
        // Initialize DP list with first number in array
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        // Iterate through remaining array elements
        for (int i = 1; i < nums.length; i++) 
            // If recently added element is less than current element, add element to list
            if (dp.getLast() < nums[i]) 
                dp.add(nums[i]);
            
            // Else
            else {
                // Find index of smallest value in DP list greater than current element
                int idx = dp.size();
                for (int j = 0; j < dp.size(); j++)
                    if (nums[i] < dp.get(j)) {
                        idx = j;
                        break;
                    }
                
                // If index is 0 or current element is not present in DP, update index with current element
                if (idx == 0 || dp.get(idx - 1) != nums[i])
                    dp.set(idx, nums[i]);
            }
        
        // Return size of DP list
        return dp.size();
    }

  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
    
    // Read array
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    
    // Function Call
    System.out.println(longestIncreasingSubsequences(arr));
  }
}
