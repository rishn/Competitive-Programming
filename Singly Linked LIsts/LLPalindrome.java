import java.util.*;

class LLPalindrome {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
 	
    // Declare LL
    LinkedList<Integer> ll1 = new LinkedList<Integer>(), ll2 = new LinkedList<Integer>();
    
    // Read size
    int n = sc.nextInt();
    
    //Read LL
    for (int i = 0; i < n; i++) {
      ll1.add(sc.nextInt());
    }
    
    // Find reverse of LL
    for (int i : ll1) {
      ll2.addFirst(i);
    }
    
    // Flag
    boolean flag = true;
    
    // Check if palindrome
    for (int i = 0; i < ll1.size() / 2; i++)
      if (ll1.get(i) != ll2.get(i)) {
        flag = false;
        break;
      }
    
    // Output
    System.out.println((flag ? "True" : "False"));
  }
}