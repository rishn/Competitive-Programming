import java.util.*;

class CombinationSum {
  static void sumCombos(int[] nums, int target, int index, List<Integer> combo) {
    // Base case
    if (target == 0) {
      for (int i : combo)
        System.out.print(i + " ");
      System.out.println();
      return;
    }
    
    // Undesired combination (overshoot)
    if (target < 0)
      return;
    
    // If target has not been reached, iterate remaining candidates
    for (int i = index; i < nums.length; i++)
      // If taeget has not crossed
      if (target - nums[i] >= 0) {
        // Add candidate to combination
        List<Integer> temp = new ArrayList<>(combo);
        temp.add(nums[i]);
        
        // Update remaining target and call recursively
        sumCombos(nums, target - nums[i], i, temp);
      }
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read size and target
    int n = sc.nextInt(), target = sc.nextInt();
    
    // Read array
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();
    
    // Output
    sumCombos(nums, target, 0, new ArrayList<>());
  }
}