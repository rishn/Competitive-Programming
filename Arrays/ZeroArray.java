/*
You are given an Array ‘Arr’ of ‘N’ positive integers. You need to convert the given array ‘Arr’ to Zero-Array.

An Array ‘A’ is know as Zero-Array if the bitwise AND (&) of all the elements of the array is Zero.

In other words, Array ‘A’ with length ‘L’ is known as Zero –Array if A[0] & A[1] & A[2]………& A[L] = 0.

For example array [1,2,3]is a Zero-Array, you can perform the following move any number of times:

Choose any array elements from Array ‘Arr’, say Arr[i], and flip exactly one bit in Arr[i] (Flipping a bit means if the bit is 1 then covert it to 0 and if the bit is 0 then convert it to 1)

You need to find the minimum number of moves to convert the given array ‘Arr’ to Zero-Array .
*/

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
