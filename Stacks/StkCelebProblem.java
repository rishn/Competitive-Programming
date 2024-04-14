import java.util.*;
class Celeb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();                   // No. of people
        int people[][] = new int[n][n];         // n x n matrix

        // Inputs
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                people[i][j] = sc.nextInt();
        
        // Declare a stack and push all IDs to it
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++)
            stk.push(i);

        // Process
        while (stk.size() > 1) {
            int a = stk.pop(), b = stk.pop();
            if (people[a][b] == 1)
                // Person with ID a is not a celeb
                stk.push(b);
            else
                // Person with ID b is not a celeb
                stk.push(a);
        }

        // Potential celeb
        int pc = stk.peek();

        // Verify whether potential celeb knows anyone
        for (int i = 0; i < n; i++)
            if (people[pc][i] == 1) {
                // Verification failed
                System.out.println("No celeb found");
                return;
            }

        // Verify whether potential celeb is known by all
        for (int i = 0; i < n; i++)
            if (i != pc && people[i][pc] == 0) {
                // Verification failed
                System.out.println("No celeb found");
                return;
            }
        
        // Print celeb found
        System.out.println("Celeb ID = " + pc);
    }
}