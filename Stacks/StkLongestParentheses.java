import java.util.*;

class LongestParentheses {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Stack
    Stack<Integer> stk = new Stack<>();
    // Base of next valid substring
    stk.push(-1);
    
    // Max length variable
    int l = 0;
    
    // Read input
    String str = sc.next();
    
    for (int i = 0; i < str.length(); i++) {
      // If left parenthesis encountered, push its index
      if (str.charAt(i) == '(')
        stk.push(i);
      
      // If right parenthesis encountered
      else {
        // Pop index of previous left parenthesis
        if (! stk.empty())
          stk.pop();
       	
        // If stack is not empty, update max length with length of
        // valid substring from base (top index)
        if (! stk.empty())
          l = Math.max(l, i - stk.peek());
        
        // If stack is empty, push index as base to next valid substring
       	else
          stk.push(i);
      }
    }
    
    // Output
    System.out.println(l);
  }
}
