import java.util.*;

class Graph {
  // No. of vertices
  int v;
  
  // Traversal list
  List<Integer> trav;
  
  // Adjacency list
  LinkedList<Integer>[] adj;
  
  // Constructor
  Graph(int v) {
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i++)
      adj[i] = new LinkedList();
    
    trav = new ArrayList<>();
  }
  
  // Add vertex connected via edge to adjacency list of vertex
  void addEdge(int v, int u) {
    adj[u].add(v);
  }
  
  // DFS
  void DFS(int v, boolean visited[]) {
    // Mark the current node as visited and add to traversal list
    visited[v] = true;
    trav.add(v);

    // Recursion for all the vertices adjacent to this vertex
    for (int u : adj[v])
      if (visited[u])
        trav.remove(Integer.valueOf(u));
      else
        DFS(u, visited);
  }
}

class CourseSchedule {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Read vertices and edges
    int v = sc.nextInt(), e = sc.nextInt();
    
    // Declare graph
    Graph g = new Graph(v);
    
    // Read edges
    for (int i = 0; i < e; i++)
      g.addEdge(sc.nextInt(), sc.nextInt());
      
    // Traverse graph
    g.DFS(0, new boolean[v]);
    
    // Output
    System.out.println(g.trav.size() == v ? "True" : "False");
  }
}