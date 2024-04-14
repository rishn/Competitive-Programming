import java.util.*;

class PostfixEval {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // No. of expressions
    int n = sc.nextInt();
    
    // Process
    for (int t = 0; t < n; t++) {
    
      // Read expression
      String pfx = sc.next();

      //Stack
      Stack<Integer> stk = new Stack<>();

      // Iterate through expression
      for (int i = 0; i < pfx.length(); i++) {
        char curr = pfx.charAt(i);
        
        // Operand, push to stack
		if (curr >= '0' && curr <= '9')
          stk.push(curr - '0');
        
        // Operator, pop 2 operands from stack, perform required operation and add to stack
        else {
          // Operands
          int x = stk.pop(), y = stk.pop();
          
          // Operation
          switch (curr) {
            case '+':
              stk.push(y + x);
              break;
            case '-':
              stk.push(y - x);
              break;
            case '*':
              stk.push(y * x);
              break;
            case '/':
              stk.push(y / x);
              break;
          }
        }
      }
      
      // Output - top of stack
      System.out.println(stk.pop());
    }
  }
}