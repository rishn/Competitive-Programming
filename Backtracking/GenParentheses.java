import java.util.*;

class GenerateParentheses {
  static void printParentheses(String str, int n, int s, int e) {
    // Base cases
    if (n == 0)
      return;
    if (e == n) {
      System.out.print(str + " ");
      return;
    }
    
    // Update string based on start and end pointers
    // Check if open bracket is to be added when start pointer has not reached count
    if (s < n)
      printParentheses(str + "(", n, s + 1, e);
    
    // Check if close bracket is to be added when start has crossed end pointer
    if (s > e)
      printParentheses(str + ")", n, s, e + 1);
    
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read n
    int n = sc.nextInt();
    
    // Output
    printParentheses("", n, 0, 0);
  }
}
