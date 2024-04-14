import java.util.*;

class BasicCalculator {
  static List<String> infixToPostfix(String exp) {
    // Stack
    Stack<Character> stk = new Stack<>();

    // Potfix array
    List<String> result = new ArrayList<>();

    // Operand counter
    int opd = 0;

    // Flags and counters for sign operator
    boolean sign = false, sn_op = false;
    int sn_c = 0;

    // Iterate through given expression
    for (int i = 0; i < exp.length(); i++) {
      char curr = exp.charAt(i);

      // Operator, pop all operators in stack
      if (curr == '+' || curr == '-') 
        // Check for possibility of sign operator inside parentheses
        if (curr == '-' && exp.charAt(i - 1) == '(') {
          sn_c++;
          sign = true;
          if (exp.charAt(i + 1) != '(')
            sn_op = true;
        }

      else {
        while (! stk.isEmpty() && (stk.peek() == '+' || stk.peek() == '-'))
          result.add("" + stk.pop());
        stk.push(curr);                         // Add operator to stack
      }							   

      // Left parenthesis, push to stack
      else if (curr == '(') {
        // Check for sign operator
        if (i > 1 && exp.charAt(i - 1) == '-' && exp.charAt(i - 2) == '(')
          stk.push('[');
        else
          stk.push(curr);
      }

      // Right parenthesis, pop from stack until left paranthesis and add to result
      else if (curr == ')') {
        while (! stk.isEmpty() && stk.peek() != '(' && stk.peek() != '[')
          result.add("" + stk.pop());
        char p = stk.pop();									// Pop left paranthesis

        // If sign operator was encountered, add it to result before next operator
        if (p == '[' && sign) {
          result.add("-s");
          sn_c--;
          if (sn_c == 0)
            sign = false;
        }
      }

      // Operand, add to result
      else if (Character.isDigit(curr)) {
        // Increment operand counter
        opd++;

        // Add digits to operand string until non-numeric character is encountered
        String operand = "";
        while (i < exp.length() && Character.isDigit(exp.charAt(i)))
          operand += exp.charAt(i++);
        i--;
        result.add(operand);

        // If sign operator was encountered, add it to result before next operator
        if (sn_op) {
          result.add("-s");
          sn_c--;
          sn_op = false;
          if (sn_c == 0)
            sign = false;
        }
      }

      else
        return new ArrayList<>();
    }

    // If no operands or operators present
    if (opd == 0)
      return new ArrayList<>();

    // Pop remaning operators from stack and add to result
    while (! stk.isEmpty()) {
      result.add("" + stk.pop());
    }

    // Return postfix
    return result;
  }

  static int postfixEval(List<String> pfx) {
    // Empty case
    if (pfx.size() == 0)
      return 0;

    //Stack
    Stack<Integer> stk = new Stack<>();

    // Iterate through expression
    for (String curr : pfx) 
      // Operand, push to stack
      if (Character.isDigit(curr.charAt(0)) || (curr.length() > 1 && 
          Character.isDigit(curr.charAt(1))))
        stk.push(Integer.parseInt(curr));

    // Operator, pop 2 operands from stack, perform required operation and add to stack
    else {
      // Second operand
      if (stk.isEmpty())
        return 0;
      int x = stk.pop();

      // Check if unary or binary operation
      if (! curr.equals("-s") && stk.isEmpty())
        return 0;

      // Second operand
      int y = 0;
      if (! curr.equals("-s"))
        y = stk.pop();

      // Operation
      switch (curr) {
        case "+":
          stk.push(y + x);
          break;

        case "-":
          stk.push(y - x);
          break;

        case "-s":
          stk.push(y - x);
          break;

        default:
          return 0;
      }
    }

    // Return result
    int result = stk.pop();
    if (stk.isEmpty())
      return result;
    else
      return 0;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Output
    System.out.println(postfixEval(infixToPostfix("(" + sc.nextLine() + ")")));
  }
}