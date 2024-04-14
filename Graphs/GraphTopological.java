// TOPOLOGICAL SORT
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
    }
}

class Topological {
    static void DFS(Graph g, int v, boolean[] visited, Stack<Integer> stk) {
        // Mark vertex as visited
        visited[v] = true;

        // Visit adjacent vertices of vertex
        for (int i = 0; i < g.adj[v].size(); i++) {
            // Get adjacent vertex
            int u = g.adj[v].remove();
            g.adj[v].add(u);

            // If not visited, perform DFS at vertex with stack
            if (! visited[u])
                DFS(g, u, visited, stk);
        }

        // Push current vertex to stack
        stk.push(v);

    }

    static void topologicalSort(Graph g) {
        // Decalre stack and visit log for DFS
        Stack<Integer> stk = new Stack<>();
        boolean visited[] = new boolean[g.v];

        // Iterate through all vertices
        for (int i = 0; i < g.v; i++)
            // If not visited, perform DFS at vertex with stack
            if (! visited[i])
                DFS(g, i, visited, stk);

        // Output
        while (! stk.isEmpty())
            System.out.print(stk.pop() + " ");
    }

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
        topologicalSort(g);
        System.out.println();
    }
}