import java.util.*;

class SpiralMatrix {
  // Function to print in spiral order
  static void spiralOrder(int[][] matrix, int r, int c)
  {
	// Base case
    if (matrix.length == 0)
      return;
	
    // Visted array
    boolean[][] visited = new boolean[r][c];
    
    // Arrays to decrement or increment array indexes across row/col
    int[] dr = { 0, 1, 0, -1 }, dc = { 1, 0, -1, 0 };
    
    // Current cell indices and traversal order indicator
    int x = 0, y = 0, di = 0;

    // Iterate from 0 to R * C - 1
    for (int i = 0; i < r * c; i++) {
      // Print cell at (x, y) and mark it as visited
      System.out.print(matrix[x][y] + " ");
      visited[x][y] = true;
      
      // Find next cell to be traversed spirally
      int ci = x + dr[di], cj = y + dc[di];
      
      // If next cell is valid and unvisited, make it curr cell
      if (ci >= 0 && ci < r && cj >= 0 && cj < c && ! visited[ci][cj]) {
        x = ci;
        y = cj;
      }
      
      // Else
      else {
        // Increment traversal order indicator and find next cell
        di = (di + 1) % 4;
        x += dr[di];
        y += dc[di];
      }
    }
  }

  // Driver Code
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);

    // Read rows, cols
    int r = sc.nextInt(), c = sc.nextInt();

    // Read matrix
    int[][] mat = new int[r][c];
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        mat[i][j] = sc.nextInt();


    // Output
    spiralOrder(mat, r, c);
  }
}
