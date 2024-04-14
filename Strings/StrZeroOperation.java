import java.util.*;

class ZeroOperation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Read size and k
    int n = sc.nextInt(), k = sc.nextInt();
    
    // Read strings
    String str1 = sc.next(), str2 = sc.next();
    
    // Calculate frequencies
    int[] f1 = new int[26], f2 = new int[26];
    
    for (int i = 0; i < n; i++)
      f1[str1.charAt(i) - 'a']++;    
    for (int i = 0; i < n; i++)
      f2[str2.charAt(i) - 'a']++;
    
    // Compare frequencies of strings
    for (int i = 25; i > -1; i--)
      // If group of similar characters is reachable using zero operation
      if (f2[i] % k == 0) {
        // Check if a group of similar number is available in first string
        boolean flag = false;
        for (int j = i; j > -1; j--)
          if (f1[j] == f2[i]) {
            flag = true;
            f1[j] = 0;
            break;
          }
        
        // If not present
        if (! flag) {
          System.out.println("No");
          return;
        }
      }
      
      // If it cannot be reached
      else {
        System.out.println("No");
    	return;
      }
    
    // If flow has reached here, first string can be converted to second
    System.out.println("Yes");
  }
}