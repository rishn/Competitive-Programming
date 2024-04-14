import java.util.*;

class PhoneLetters {
  // Keypad
  static String[] keypad = new String[]{"abc", "def", "ghi", "jkl", 
                                        "mno", "pqrs", "tuv", "wxyz"};
  
  static void combos(String phone, String next, int index) {
    // Base case
    if (index == -1) {
      System.out.print(next + " ");
      return;
    }
    
    // Loop through all the letters corresponding to the current digit
    for (char c : keypad[phone.charAt(index) - '0' - 2].toCharArray())
      combos(phone, c + next, index - 1);
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read phone number
    String phone = sc.next();
    
    // Output
    combos(phone, "", phone.length() - 1);
  }
}