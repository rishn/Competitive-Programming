// GRAPH DFS
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
    
    // DFS
    void DFS(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recursion for all the vertices adjacent to this vertex
        for (int u : adj[v])
            if (! visited[u])
                DFS(u, visited);
    }
}

class GraphDFS {
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
        g.DFS(sc.nextInt(), new boolean[v]);
        System.out.println();
    }
}