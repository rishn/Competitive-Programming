import java.util.*;

class StockSpan {
	static int[] span(int[] stocks, int n) {
  	// Initialize stack and result array
  	Stack<Integer> stk = new Stack<>();
    int[] res = new int[n];
    
    // Base case
    stk.push(0);
    res[0] = 1;
    
    // Process
    for (int i = 0, j = 0; i < n; i++) {
    	while (! stk.isEmpty() && stocks[stk.peek()] <= stocks[i])
      	stk.pop();
      
      res[i] = stk.isEmpty() ? i + 1 : i - stk.peek();
      stk.push(i);
    }
    
    // Return result array
    return res;
  }
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read size of arrays
        int n = sc.nextInt();
        
        // Read arrays
        int[] stocks = new int[n];
        for (int i = 0; i < n; i++)
            stocks[i] = sc.nextInt();
        
        // Call function
        System.out.println(Arrays.toString(span(stocks, n)));
    }
}
