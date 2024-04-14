import java.util.*;

class BTDiameter {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read inputs and count number of nodes
    int a = sc.nextInt(), n = 0;
    while (a != -1) {
      n++;
      a = sc.nextInt();
    }
    
    // Output
    System.out.println("Diameter of the given binary tree is " + (n - (int)(Math.log(n) / Math.log(2)) - 1));
  }
}