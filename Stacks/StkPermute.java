import java.util.*;
class Permute {
	static Boolean check(int[] input, int[] output, int n) {
  	// Initialize stack
  	Stack<Integer> stk = new Stack<>();
    
    // Process
    for (int i = 0, j = 0; i < n; i++) {
    	// Push element from input array
    	stk.push(input[i]);
      
      // If top of stack equals current element of output
      if (! stk.isEmpty() && stk.peek() == output[j]) {
      	stk.pop();
        j++;
      }
    }
    
    // If all stack elements are popped
    if (stk.isEmpty())
    	return true;
    
    // Output cannot be permuted from input
    return false;
  }
  
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
    
    // Read size of arrays
    int n = sc.nextInt();
    
    // Read inputs
    int[] input = new int[n], output = new int[n];
    for (int i = 0; i < n; i++)
    	input[i] = sc.nextInt();
    for (int i = 0; i < n; i++)
    	output[i] = sc.nextInt();
    
    // Call function
    System.out.println(check(input, output, n) ? "Yes" : "No");
  }
}
