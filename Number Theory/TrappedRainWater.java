import java.util.Scanner;

class TrappedWater {
  static int trappedWater(int[] arr, int n) {
    // Declare variables
    int prev = arr[0], index = 0, water = 0, temp = 0;
    
    // Iterate through array
    for (int i = 1; i < n; i++)
      // If elevation greater than or equal to previous elevation is found
      if (arr[i] >= prev) {
        // Update previous elevation and its index
        prev = arr[i];
        index = i;
        
        // Reset temporary variable
        temp = 0;
      }
      
      // Else
      else {
        // Add difference in elevations to trapped water and temp variable
        water += prev - arr[i];
        temp += prev - arr[i];
      }
    
    // If no greater elevation was found at the end of the array
    if (index < n - 1) {
      // Subtract excess water which is to be re-computed from end to previous elevation
      water -= temp;
      
      // Reset previous elevation to last elevation
      prev = arr[n - 1];
      
      // Iterate from end of array to previous elevation
      for (int i = n - 1; i >= index; i--)
      // If elevation greater than or equal to previous elevation is found
        if (arr[i] >= prev)
        // Update previous elevation
          prev = arr[i];
      	
        // Else
      	else
          // Add difference in elevations to trapped water
          water += prev - arr[i];
    }
    
    // Return total trapped water
    return water;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read inputs
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    
    // Output
    System.out.println(trappedWater(arr, n));
  }
}