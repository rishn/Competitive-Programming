import java.util.Scanner;

class Tower {
    static void hanoi(int n, char src, char dest, char aux) {
        // Base case
        if (n == 1) {
            System.out.println(src + "->" + dest);
            return;
        }

        // Recursive calls
        hanoi(n - 1, src, dest, aux);
        hanoi(1, src, aux, dest);
        hanoi(n - 1, aux, src, dest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Call function
        hanoi(sc.nextInt(), 'A', 'B', 'C');
    }
}