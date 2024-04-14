import java.util.Scanner;

class LongestDistinctSubstring {
  public static void main(String args[]) {
 	Scanner sc = new Scanner(System.in);
    
    // Read string
    String str = sc.next();
    
    // Visit log
    boolean[] chars = new boolean[256];
    
    // Start and end pointers
    int s = 0, e = 0, max = 0;
    
    // Base case
    if (str.length() < 2) {
      System.out.println(str.length());
      return;
    }
    
    // Process
    while (e < str.length()) {
      // If char is visited
      if (chars[str.charAt(e)])
        // Left pointer moves to right and marks visited chars
        // until repeating char is not part of window
        while (chars[str.charAt(e)])
          chars[str.charAt(s++)] = false;
      
      // Char at end of window is visited
      chars[str.charAt(e)] = true;
	  
      // Calculating current window length and updation
      max = Math.max(max, e++ - s + 1);
    }
    
    // Final length
    System.out.println(max);
  }
}