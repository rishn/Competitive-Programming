import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NQueensAll {
    private int N;

    public NQueensAll(int n) {
        this.N = n;
    }

    // Method to print a single solution
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Utility to check if a queen can be placed at board[row][col]
    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check this row on the left
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on the left
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on the left
        for (i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursively solve N-Queens and collect solutions
    boolean solveNQUtil(int board[][], int col, List<int[][]> solutions) {
        // If all queens are placed, add the solution
        if (col >= N) {
            int[][] solution = new int[N][N];
            for (int i = 0; i < N; i++)
                System.arraycopy(board[i], 0, solution[i], 0, N);
            solutions.add(solution);
            return true;
        }

        // Try placing a queen in all rows for this column
        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Place queen
                res = solveNQUtil(board, col + 1, solutions) || res; // Recur for the next column
                board[i][col] = 0; // Backtrack
            }
        }
        return res;
    }

    // Wrapper to collect all solutions
    List<int[][]> solveNQ() {
        int[][] board = new int[N][N];
        List<int[][]> solutions = new ArrayList<>();
        solveNQUtil(board, 0, solutions);

        if (solutions.isEmpty()) {
            System.out.println("No solution exists");
        } else {
            for (int[][] solution : solutions) {
                printSolution(solution);
            }

            System.out.println(solutions.size() + " solutions");
        }

        return solutions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        NQueensAll Queen = new NQueensAll(n);
        Queen.solveNQ();

        sc.close();
    }
}
