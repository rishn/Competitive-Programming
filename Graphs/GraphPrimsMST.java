import java.util.*;

class Edge implements Comparable<Edge> {
  int v, wt;
  
  Edge(int v, int wt) {
  	this.v = v;
    this.wt = wt;
  }
  
  // Overrriden abstract method of interface Comparable
  public int compareTo(Edge e) {
    return this.wt - e.wt;
  }
}

class Graph {
  // No. of vertices
  int v;
  
  // Adjacency list
  LinkedList<Edge>[] adj;
  
  // Constructor
  Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++)
      adj[i] = new LinkedList();
  }
  
  // Add vertex connected via edge to adjacency list of vertex
  void addEdge(int v, int u, int wt) {
    adj[v].add(new Edge(u, wt));
    adj[u].add(new Edge(v, wt));
  }
  
  // Prims
  int primsMST() {
    // Declare priority queue
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    pq.add(new Edge(0, 0));
    
    // Visit log
    boolean[] visited = new boolean[this.v];
    int cost = 0;
    
    // For every edge in queue
    while (! pq.isEmpty()) {
      Edge e = pq.remove();
      
      // If connected vertex is not visited
      if (! visited[e.v]) {
        // Add weight of edge to cost and mark vertex as visited
        cost += e.wt;
        visited[e.v] = true;
        
        // For every edge in adjacency list of vertex
        for (Edge ed : adj[e.v])
          // Add unvisited vertices edges to queue
          if (! visited[ed.v])
            pq.add(new Edge(ed.v, ed.wt));
      }
    }
    
    // Required cost
    return cost; 
  }
}

class PrimsMST {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read vertices and edges
    int v = sc.nextInt(), e = sc.nextInt();
    
    // Declare graph
    Graph g = new Graph(v);
    
    // Read edges
    for (int i = 0; i < e; i++)
      g.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
    
    // Output
    System.out.println(g.primsMST());
  }
}
