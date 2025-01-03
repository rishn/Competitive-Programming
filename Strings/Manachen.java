import java.util.*;

public class Manachen {
    static void findLongestPalindromicString(String text) {
        int N = text.length();
        if (N == 0) return;

        // Preprocess the input string
        StringBuilder s = new StringBuilder("^");
        for (int i = 0; i < N; i++) 
            s.append('#').append(text.charAt(i));
        s.append('#').append('$');
        
        N = s.length();
        int[] L = new int[N]; // LPS Length Array
        Arrays.fill(L, 0);
        
        int C = 0;  // centerPosition
        int R = 0;  // centerRightPosition
        int maxLength = 0; // maximum length of palindrome found
        int maxCenter = 0; // center index of longest palindrome

        for (int i = 1; i < N - 1; i++) {
            int mirror = 2 * C - i;
            if (i < R) 
                L[i] = Math.min(R - i, L[mirror]);
            
            // Try to expand the palindrome around 'i'
            while (s.charAt(i + L[i] + 1) == s.charAt(i - L[i] - 1))
                L[i]++;

            // Adjust center and right boundary if expanded beyond R
            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }

            if (L[i] > maxLength) {
                maxLength = L[i];
                maxCenter = i;
            }
        }

        // Extract the longest palindrome substring
        int start = (maxCenter - maxLength) / 2;
        String result = text.substring(start, start + maxLength);
        System.out.println("Longest Palindromic Substring: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        findLongestPalindromicString(text);

        sc. close();
    }
}
