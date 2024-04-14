import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read string
        String str = sc.next();
        
        // Length
        int n = str.length();
        
        // Result
        String res = "";
        
        // Process
        for (int i = 1; i < n; i++)
            if (str.substring(0, i).equals(str.substring(n - i, n)))
                res = str.substring(0, i);
        
        // Output
        System.out.println(res);
    }
}
