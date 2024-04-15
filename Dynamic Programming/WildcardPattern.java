import java.util.Scanner;

class Wildcard {
  static boolean isMatch(String s, String p) {
    // String and pattern pointers
    int i = 0, j = 0;

    // Variables to store positions before sequence wildcard
    int sSeq = -1, pSeq = -1; 

    while (i < s.length()) {
      // If string and pattern characters match or character wildcard encountered
      if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
        i++;
        j++;
      } 

      // If sequence wildcard encountered
      else if (j < p.length() && p.charAt(j) == '*') {
        // Store string position before sequence wildcard
        sSeq = i;

        // Record sequence wildcard position in pattern and proceed to next pattern character
        pSeq = j++;
      } 
      
      // If sequence wildcard was encountered previously
      else if (pSeq != -1) {
        // Reset string pointer to the position after the last sequence wildcard
        i = ++sSeq; 

        // Move pattern pointer to the character after last sequence wildcard
        j = pSeq + 1;
      } 

      // Characters do not match
      else
        return false;
    }

    // Check if remaining characters in pattern are sequence wildcards and skip them
    while (j < p.length() && p.charAt(j) == '*')
      j++;

    // If pattern is traversed entirely, string and pattern match
    return j == p.length(); 
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      
    // Output
    System.out.println(isMatch(sc.nextLine(), sc.nextLine()));
  }
}
