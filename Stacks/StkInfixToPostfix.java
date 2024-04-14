import java.util.*;

class InfixToPostfix {
  static int priority(char op) {
    if (op == '^')						// Exponentiation
      return 3;
    else if (op == '*' || op == '/') 	// Product
      return 2;
    else if (op == '+' || op == '-')	// Summation
      return 1;
    else								// Invalid operation
      return -1;
  }
  
  static boolean isLeftAssociative(char op) {
    // Exponentiation, right associative
    if (op == '^')					
      return false;
    
    // Else, left associative
   	return true;
  }
  static String infixToPostfix(String exp) {
    // Stack
    Stack<Character> stk = new Stack<>();
    
    // Potfix expression
    String result = "";
    
    // Iterate through given expression
    for (int i = 0; i < exp.length(); i++) {
      char curr = exp.charAt(i);
      
      // Operator, if left associative, pop all operators in stack whose precedence is not less than current operator
      if (curr == '^' || curr == '+' || curr == '*' || curr == '/' || curr == '-') {
		// If right associative, current operator has greater precedence than same operator in stack, do not pop
        while (! stk.isEmpty() && priority(curr) <= priority(stk.peek()) && isLeftAssociative(curr))
       	  result += stk.pop();
        
        stk.push(curr);					// Add operator to stack
      }
      
      // Left parenthesis, push to stack
      else if (curr == '(')
        stk.push(curr);
      
      // Right parenthesis, pop from stack until left paranthesis and add to result
      else if (curr == ')') {
      	while (! stk.isEmpty() && stk.peek() != '(')
          result += stk.pop();
        stk.pop();						// Pop left paranthesis
      }
      // Operand, add to result
      else
        result += curr;
    }
    
    // Pop remaning elements from stack and add to result
    while (! stk.isEmpty())
      result += stk.pop();
    
    // Return postfix
    return result;
  }
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Output
    System.out.println(infixToPostfix(sc.next()));
  }
}