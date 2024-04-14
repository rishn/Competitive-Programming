import java.util.Scanner;

class Window {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read length of array
        int n = sc.nextInt();

        // Declare array and read inputs
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        
        // Read window size
        int k = sc.nextInt();

        // Maximum number variable
        int max = arr[0];

        // Find first maximum
        for (int i = 1; i < k; i++)
            if (max < arr[i])
                max = arr[i];
        System.out.println(max);

        // Find maxima of following windows
        for (int i = k; i < n; i++) {
            if (max < arr[i]) 
                max = arr[i];
            System.out.println(max);
        }
    }
}