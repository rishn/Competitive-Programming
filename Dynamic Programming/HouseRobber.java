import java.util.*;

class HouseRobber {
    static int[] dpArray;
    
    static int maxSteal(int[] houses, int n) {
        // Base cases
        if (n < 0)
            return 0;
        if (n == 0)
            return houses[0];
        
        // If element of dpArray is already updated, return the same
        if (dpArray[n] != -1)
            return dpArray[n];
        
        // Else, update with max of amount after including current house
        // and not including current house
        return dpArray[n] = Math.max(houses[n] + maxSteal(houses, n - 2), maxSteal(houses, n - 1));
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Read houses
        int n = sc.nextInt();
        int[] houses = new int[n];
        for (int i = 0; i < n; i++)
            houses[i] = sc.nextInt();
        
        // Initialize array to store DP intermediate values with -1s
        dpArray = new int[n + 1];
        Arrays.fill(dpArray, -1);
        
        // Output
        System.out.println(maxSteal(houses, n - 1));
    }
}
