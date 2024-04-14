import java.util.Scanner;

class EditDistance {
  static int editDistance(String s, String t) {
    // Lengths of the two input strings and previous character
    int m = s.length(), n = t.length(), prev;

    // Initialize an array to store the current row of edit distances with values from 0 to n
    int[] curr = new int[n + 1];
    for (int j = 0; j <= n; j++) {
      curr[j] = j;
    }
    
    // Iterate through s
    for (int i = 1; i <= m; i++) {
      // Store the value of the previous row's first column and update current row
      prev = curr[0];
      curr[0] = i;
      
      // Iterate through t
      for (int j = 1; j <= n; j++) {
        // Store the current value before updating it.
        int temp = curr[j];

        // If the characters at the current positions in s and t are the same
        if (s.charAt(i - 1) == t.charAt(j - 1))
          // If they are the same, no additional cost is incurred.
          curr[j] = prev;
        
        // If the characters are different
        else
          // Calculate the minimum of three operations:
          // 1. Deletion (previous value)
          // 2. Insertion (current row's previous value)
          // 3. Substitution (diagonal previous value)
          curr[j] = 1 + Math.min(Math.min(prev, curr[j - 1]), curr[j]);
        
        // Update the previous value with the stored temporary value
        prev = temp;
      }
    }
    
    // The value in the last cell of the current row represents the edit distance
    return curr[n];
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Output
    System.out.println(editDistance(sc.nextLine(), sc.nextLine()));
  }
}
