import java.util.Scanner;
class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input
        String str = sc.next();

        // Length
        int n = str.length();

        // Pointers
        int s = 0, e = n - 1;

        // Counter
        int c = 0;

        while (s < e)
            if (str.charAt(s) == str.charAt(e)) {
                s++;
                e--;
            }
            else {
                s = ++c;
                e = n - 1;
            }
        
        // Temporary addend string
        String temp = "";

        // Extra characters
        for (int i = c - 1; i >= 0; i--)
            temp += str.charAt(i);
        
        System.out.println(str += temp);
    }
}
