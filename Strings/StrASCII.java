import java.util.Scanner;
class ASCIIString {
    static float averageASCII(String str) {
        // Base case
        if (str.length() == 0)
            return -1;

        float tot = 0;
        for (int i = 0; i < str.length(); i++)
            tot += str.charAt(i);
        return tot / str.length();
    }

    static char smallestMissing(String str) {
        int[] alpha = new int[26];
        
        // Update frequencies of letters
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                alpha[str.charAt(i) - 'a']++;
        
        // Check for smallest letter with 0 frequency
        for (int i = 0; i < 26; i++)
            if (alpha[i] == 0)
                return (char)('a' + i);
        
        // No alphabet missing
        return '!';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input
        String str = sc.next();

        // Function calls
        System.out.printf("%.2f\n%c\n", averageASCII(str), smallestMissing(str));
    }
}