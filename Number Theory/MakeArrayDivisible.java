import java.util.*;

class DivisibleArray {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read nums
    int n = sc.nextInt();
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    
    // Read numsDivide
    int m = sc.nextInt();
    int[] numsDivide = new int[m];
    for (int i = 0; i < m; i++)
      numsDivide[i] = sc.nextInt();
    
    // Sort nums
    Arrays.sort(nums);
    
    // Assign number less than min of nums to min variable
    int min = nums[0] - 1;
    
    // Counter for deletions
    int d = 0;
    
    // Iterate through nums
    for (int i = 0; i < n; i++)
      // If num is repeated, it has to be deleted
      if (nums[i] == min)
        d++;
      
      // Else
      else {
        // Check divisibility of new num
        int j;
        for (j = 0; j < m; j++)
          if (numsDivide[j] % nums[i] != 0)
            break;
        
        // If num divides all elements in numsDivide
        if (j == m) {
          // Return required deletions
          System.out.println(d);
          return;
        }
        
        // Else update min and increment number of deletions
        else {
          min = nums[i];
          d++;
        }
      }
    
    // If flow has reached here, no num divides entire numsDivide
    System.out.println(-1);
  }
}