import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedSubstr {
    static int[] values = new int[26];

    static void insertValues() {
        // Initialize values (weights for each letter, as an example)
        values[0] = 1;
        for (int i = 1; i < 26; i++) {
            values[i] = values[i - 1] * 2; // Example progression for values
        }
    }

    static void formedString(List<Character> s, int k) {
        int low = 0;
        int high = 25;

        while (k != 0) {
            int ind = findFloor(k, low, high);
            s.add((char) (ind + 'A'));
            k -= values[ind];
        }

        // Print the string in reverse order since we add the chars from least significant position first
        for (int i = s.size() - 1; i >= 0; i--) {
            System.out.print(s.get(i));
        }
    }

    static int findFloor(int k, int low, int high) {
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (values[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } 
            
            else 
                high = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        insertValues();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        List<Character> s = new ArrayList<>();
        formedString(s, n);

        scanner.close();
    }

}
