import java.util.*;

class ReverseK {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Declare LLs
    LinkedList<Integer> ll1 = new LinkedList<>(), ll2 = new LinkedList<>();
    
  	// Read LL  
    int a = sc.nextInt();
    while (a != -1) {
      ll1.add(a);
      a = sc.nextInt();
    }
    
    // Read k
    int i, k = sc.nextInt();
    
    // Reverse k elements continuously
    for (i = k - 1; i < ll1.size(); i += k)
    	for (int j = 0; j < k; j++) {
        	ll2.add(ll1.get(i - j));
        }
    
    // Add excess elements
    for (int j = i - k + 1; j < ll1.size(); j++)
      	ll2.add(ll1.get(j));
    
    // Output
    ll2.forEach((e)->System.out.println(e));
  }
}