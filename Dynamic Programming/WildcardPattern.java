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

// PERSONAL ATTEMPT 2
/*
class Wildcard {
  public boolean isMatch(String s, String p) {
    // Pattern and string pointer
    int i = 0, j = 0;

    // Wildcard counter
    int seq = 0;

    // Iterate through pattern
    while (i < p.length()) {
      System.out.println(j + " " + i);
      
      // If character sequence wildcard encountered
      if (p.charAt(i) == '*') {
        // Increment counter
        seq++;

        // If wildcard is at end of pattern, then string matches
        if (i + 1 == p.length())
          j = s.length();
            
        // If next pattern character is single character wildcard or
        // no string character available, skip iteration
        else if (p.charAt(i + 1) == '?' || j == s.length())
          i--;

        // Iterate through string until string character and next pattern character match
        else
          while (j < s.length() && s.charAt(j++) != p.charAt(i + 1));

        // Increment pattern pointer
        i++;
      }

      // If single character wildcard encountered
      else if (p.charAt(i) == '?') {
        // If no string character present to match
        if (j >= s.length())
          return false;

        // Increment string pointer
        j++;
      }

      // Else if pattern character does not match string character
      else if (j == s.length() || (j < s.length() && p.charAt(i) != s.charAt(j++)))
        // If character sequence wildcard was encountered once, try reverse pattern check
        if (seq > 0)
          break;
        
        // Else
        else
          return false;

      // Increment pattern pointer
      i++;
    }

    // If pattern or string is not entirely traversed
    if (i < p.length() || j < s.length()) {
      // Iterate through pattern reversely
      i = p.length() - 1;
      j = s.length() - 1;
      while (i >= 0) {
        System.out.println(j + " " + i);
        
        // If character sequence wildcard encountered
        if (p.charAt(i) == '*') {
          // If wildcard is at start of pattern, then string matches
          if (i == 0)
            j = -1;
          
          // If next pattern character is single character wildcard or
          // no string character available, skip iteration
          else if (p.charAt(i - 1) == '?' || j < 0)
            i++;

          // Iterate through string until string character and next pattern character match
          else
            while (j >= 0 && s.charAt(j--) != p.charAt(i - 1));

          // Decrement pattern pointer
          i--;
        }

        // If single character wildcard encountered
        else if (p.charAt(i) == '?') {
          // If no string character present to match
          if (j < 0)
            return false;

          // Decrement string pointer
          j--;
        }

        // Else if pattern character does not match string character
        else if (j < 0 || (j >= 0 && p.charAt(i) != s.charAt(j--)))
          return false;

        // Decrement pattern pointer
        i--;
      }

      // If pattern and string are entirely traversed
      if (i < 0 && j < 0)
        return true;
      
      // Else
      else
        return false;
    }

    // Else string entirely matches the pattern
    else
      return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      
    // Output
    System.out.println(isMatch(sc.nextLine(), sc.nextLine()));
  }
}
*/

// PERSONAL ATTEMPT 1
/*
class Wildcard {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read string and pattern
    String str = sc.nextLine();
    String[] pattern = sc.nextLine().split("\\*");
    
    // Break index
    int i = 0;
    
    // Flag
    boolean flag = false;
    
    // Check with non-empty first half of pattern
    for (i = 0; i < str.length(); i++)
      if (pattern[0].equals(str.substring(0, i))) {
        flag = true;
        break;
      }
    
    // If pattern matched
    if (flag)
      // Check with non-empty second half of pattern
      if (pattern[1] != "")
        for (int j = i; j < str.length(); j++)
          if (pattern[1].equals(str.substring(j))) {
            // Complete pattern matches
            System.out.println(true);
            return;
          }
    
      // If second half is empty
      else {
        // Complete pattern matches
        System.out.println(true);
        return;
      }
        
    // If flow has reached here, complete pattern doesn't match
    System.out.println(false);
  }
}
*/
