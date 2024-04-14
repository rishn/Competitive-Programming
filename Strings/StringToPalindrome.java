import java.util.Scanner;

class PalindromeFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input
        String str = sc.next();

        // Frequency array
        int freq[] = new int[256];

        // Iterate through string
      	for (int i = 0; i < str.length(); i++)
        	freq[str.charAt(i)]++;
      
      	// Result
     	int res = 0, odd = 0;
      
      	for (int i = 0; i < 256; i++)
          if (freq[i] % 2 == 0)
            res += freq[i];
      	  else if (odd == 0) {
            res += freq[i];
            odd++;
          }
      
        // Output        
        System.out.println(res);
    }
}
