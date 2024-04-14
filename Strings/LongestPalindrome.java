import java.util.Scanner;

class LongestPalindrome {
  // Start index, max substring length and pointers
  static int s = 0, e = 1, l, r;
  
  // Function that expands substring till palindromic property is invalid
  static void expandAndUpdate(String str, int n) {
    while (l >= 0 && r < n && str.charAt(l) == str.charAt(r)) {
      // Update max substring length and start index
      if (r - l + 1 > e) {
        s = l;
        e = r - l + 1;
      }
      l--;
      r++;
    }
  }
  
  public static void main(String args[]) {
 	Scanner sc = new Scanner(System.in);
    
    // Read string
    String str = sc.next();
    
    // Length of string
    int n = str.length();
    
    // Iterate through every character ins string
    for (int i = 0; i < n; i++) {
      // Find longest pallindrome of even size and update start index and max length
      l = i - 1;
      r = i;
      expandAndUpdate(str, n);
      
      // Find longest palindrome of odd size and update start index and max length
      l = i - 1;
      r = i + 1;
      expandAndUpdate(str, n);
    }
    
    // Output
    System.out.println(str.substring(s, s + e));
  }
}
