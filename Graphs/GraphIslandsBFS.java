import java.util.*;

class Edge {
  int u, v;
  
  Edge(int u, int v) {
    this.u = u;
    this.v = v;
  }
}

class IslandsBFS {
  
  // Rows and columns
  static int n, m;
  
  // Visited array
  static boolean[][] visited;
  
  static void BFS(int r, int c, int[][] mat) {
    // Mark cell as visited
    visited[r][c] = true;
    
    // Declare queue
    Queue<Edge> q = new LinkedList<>();
    q.add(new Edge(r, c));
    
    // For every edge in queue
    while (! q.isEmpty()) {
      r = q.peek().u;
      c = q.peek().v;
      q.remove();
      
      // Traverse neighbours and mark them as visited if land
      for (int i = -1; i < 2; i++)
        for (int j = -1; j < 2; j++) {
          int newR = r + i, newC = c + j;
          
          if (newR >= 0 && newR < n && newC >= 0 && newC < m &&
              mat[newR][newC] == 1 && ! visited[newR][newC]) {
            visited[newR][newC] = true;
            q.add(new Edge(newR, newC));
          }
        }
    }
  }
  
  static int islands(int[][] mat) {
    int count = 0;
    
    // Iterate through cells of matrix
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        // If unvisited land encountered
        if (! visited[i][j] && mat[i][j] == 1) {
          count++;
          BFS(i, j, mat);
        }
    
    // Return count
    return count;
  }
  
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read rows, cols
    n = sc.nextInt();
    m = sc.nextInt();
    
    // Read matrix
    int[][] mat = new int[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        mat[i][j] = sc.nextInt();
    
    // Initialize visited array
    visited = new boolean[n][m];
    
    // Output
    System.out.println(islands(mat));
  }
}