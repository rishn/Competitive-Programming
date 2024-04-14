import java.util.*;

class Graph {
  // No. of vertices
  int v;
  
  // Fuel cost
  int cost;
  
  // Adjacency list
  LinkedList<Integer>[] adj;
  
  // Constructor
  Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++)
      adj[i] = new LinkedList();
    
    cost = 0;
  }
  
  // Add vertex connected via edge to adjacency list of vertex
  void addEdge(int v, int u) {
    adj[v].add(u);
    adj[u].add(v);
  }
  
  // DFS
  int DFS(int v, int seats, boolean visited[]) {
    // Mark the current node as visited and print it
    visited[v] = true;
    
    // Counter for number of nodes
    int count = 1;

    // Recursion for all the vertices adjacent to this vertex
    for (int u : adj[v])
      if (! visited[u])
        count += DFS(u, seats, visited);
    
    // Update cost by no. of trips for all adjacent nodes to travel
    if (v != 0)
      cost += Math.ceil((double)count / seats);
    
    return count;
  }
}

class FuelToCapital {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read edges and compute vertices
    int e = sc.nextInt(), v = e + 1;
    
    // Declare graph
    Graph g = new Graph(v);
    
    // Read edges
    for (int i = 0; i < e; i++)
      g.addEdge(sc.nextInt(), sc.nextInt());
      
    // Calculate fuel cost with number of seats in car and DFS
    g.DFS(0, sc.nextInt(), new boolean[v]);
    
    // Output
    System.out.println(g.cost);
  }
}
