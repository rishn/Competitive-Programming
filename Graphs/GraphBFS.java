// GRAPH BFS
import java.util.*;

class Graph {
    // No. of vertices
    int v;
    
    // Adjacency list
    LinkedList<Integer>[] adj;
    
    // Constructor
    Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }
    
    // Add vertex connected via edge to adjacency list of vertex
    void addEdge(int v, int u) {
        adj[v].add(u);
        adj[u].add(v);
    }
    
    // BFS using queue
    void BFS(int s) {
        // Declare a queue and visit log for BFS
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
 
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        q.add(s);
 
        // Iterate over the queue
        while (! q.isEmpty()) {
            // Remove a vertex from queue and print it
            int curr = q.remove();
            System.out.print(curr + " ");
 
            // Get all adjacent vertices of the dequeued vertex 
            // If adjacent vertex has not been visited, mark and enqueue it
            for (int v : adj[curr])
                if (! visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
        }
    }
}

class GraphBFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Read vertices and edges
        int v = sc.nextInt(), e = sc.nextInt();
        
        // Declare graph
        Graph g = new Graph(v);
        
        // Read edges
        for (int i = 0; i < e; i++)
            g.addEdge(sc.nextInt(), sc.nextInt());
        
        // Output
        g.BFS(sc.nextInt());
        System.out.println();
    }
}