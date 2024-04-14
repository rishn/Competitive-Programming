import java.util.Scanner;

class ZeroArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    // Read size of array and declare bitwise AND resultant variable
    int n = sc.nextInt(), r = 16383;
    
    // Read array elements and perform bitwise AND with resultant
    for (int i = 0; i < n; i++)
      r &= sc.nextInt();
    
    // Count no. of 1s present in resultant
    int c = 0;
    while (r > 0) {
      c += r & 1;
      r >>= 1;
    }
    
    // Output
    System.out.println(c);
  }
}
