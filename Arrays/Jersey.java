/*
Jack is a sports teacher at St. Patrick’s School. He makes games not only to make the student fit, but also smart. So, he lined up all the N number of students in his class. 
At each position he has fixed a board with the integer number printed on it. Each of the numbers are unique and are in exactly the range of N. 
Let us say there are 10 students, then the boards will be printed with numbers from 1 to 10 in a random order given by the sequence A[].

As a rule, all students wear a jersey with their numbers printed on it. So, if there are N students, each will have a number, just like a football team.

Now, in the beginning, all the students will stand as per the increasing order of their jersey numbers, from left to right.

The only difference will be their respective board number which is placed at their respective location. The board location is fixed and cannot be changed. 
*/

import java.util.*;

class Jersey {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read array
    int n = sc.nextInt();
    int board[] = new int[n];
    for (int i = 0; i < n; i++)
      board[i] = sc.nextInt();
    
    // Result array
    int[] result = new int[n], temp =  new int[n];
    for (int i = 0; i < n; i++)
      result[i] = i + 1;
    
    // Calculate beats
    int beats = 0;
    while (true) {
      // Update positions with board array
      for (int i = 0; i < n; i++)
        temp[board[i] - 1] = result[i];
      for (int i = 0; i < n; i++)
        result[i] = temp[i];
      
      // Increment beats
      beats++;
  	  
      // Check if correct positions are reached
      boolean flag = true;
      for (int i = 0; i < n; i++)
        if (i + 1 != result[i]) {
          flag = false;
          break;
        }
      if (flag == true) {
        // Return beats if positions are reached
        System.out.println(beats);
        return;
      }
    }
  }
}
