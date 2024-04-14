import java.util.*;

class StrPermutations {
  
  // Priority queue storing permutations
  static PriorityQueue<String> perms = new PriorityQueue<>();
  
  static void permute(String str, int l, int r) {
    // Base case    
    if (l == r) {
      perms.add(str);
      return;
    }
    
    // Loop through all the letters of substirng
    for (int i = l; i <= r; i++) {
      // Swap first and current subarray elements
      char[] temp = str.toCharArray();
      char t = temp[l];
      temp[l] = temp[i];
      temp[i] = t;
      
      // Recursive call with increase in start pointer
      permute(new String(temp), l + 1, r);
    }
  }
  
  static void printQ() {
    while (! perms.isEmpty())
      System.out.println(perms.remove());
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read phone number
    String str = new String(sc.next());
    
    // Gather permutations
    permute(str, 0, str.length() - 1);
    
    // Print permutations
    printQ();
  }
}