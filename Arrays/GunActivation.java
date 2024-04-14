/*
Joe is playing a game where there are N group of balloons. He is given a gun which can shoot one round per minute.

For each round it can hit 1 balloon in K groups each.If the group has zero balloons left, then we say that particular group is destroyed completely, and it would not be counted. 
The gun is deactivated if the number of groups falls below K.

Find the maximum number of minutes the gun will be activated based on the above factors.
*/

import java.util.*;

class GunActivation {
  static int gunActiveTime(Integer[] balloons, int k) {
    // Activation time
    int res = 0;
    
    // While loop to find required activation time
    while (true) {
      // Sort leftover balloons
      Arrays.sort(balloons, Collections.reverseOrder());
      
      // If k non-empty groups are not found, return result
      if (balloons[k - 1] == 0)
        return res;
      
      // Reduce 1 balloon from first k groups
      for (int i = 0; i < k; i++)
        if (balloons[i] > 0)
 	       balloons[i]--;
      
      // Increment activation time
      res++;
    }
  }
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Read n, k
    int n = sc.nextInt(), k = sc.nextInt();
    
    // Read balloons
    Integer[] balloons = new Integer[n];
    for (int i = 0; i < n; i++)
      balloons[i] = sc.nextInt();
    
    // Output
    System.out.println(gunActiveTime(balloons, k));
  }
}
