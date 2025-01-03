import java.util.Scanner;

public class RatInMaze {
    static int N = 4;

    static boolean isSafe(int maze[][], int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && maze[x][y] == 1;
    }

    static boolean util(int maze[][], int sol[][], int x, int y) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;

            if (util(maze, sol, x + 1, y))
                return true;

            if (util(maze, sol, x, y + 1))
                return true;

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j;

        int maze[][] = new int[N][N];
        for (i = 0; i < N; i++)
            for (j = 0; j < N; j++)
                maze[i][j] = sc.nextInt();

        int sol[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

        if (util(maze, sol, 0, 0))
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++)
                    System.out.print(sol[i][j] + " ");
                    
                System.out.println();
            }

        else
            System.out.println("No solution");
    }
}
