import java.util.*;

class ShortestPalindrome {
  static int getMinCharfromLPS(String str, int n) {    
    // LPS array
    int[] lps = new int[n];
    lps[0] = 0;
    
    // Iterators
    int i = 1, l = 0;
    
    while (i < n) {
      if (str.charAt(i) == str.charAt(l))
      	lps[i++] = ++l;
      
      else if (l != 0)
        l = lps[l- 1];
      
      else
        lps[i++] = 0;
    }
    
    return lps[n - 1];
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Read string
    String str = sc.next();
    StringBuilder s = new StringBuilder();
    s.append(str);
    
    // Length of string and index from which extra characters to be printed start
    int n = str.length(), min = getMinCharfromLPS(str + "$" + s.reverse().toString(), n * 2 + 1);
    
    // Print extra characters
    for (int i = n - 1; i >= min; i--)
      System.out.print(str.charAt(i));
    
    // Print original string
    System.out.println(str);
  }
}