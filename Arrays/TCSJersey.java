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