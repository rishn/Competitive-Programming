// BELLMAN FORD
import java.util.*;

// Custom edge class
class Edge {
    int dest, wt;

    public Edge(int v, int w) {
        dest = v;
        wt = w;
    }
}

// Custom graph class
class Graph {
    int v;
    LinkedList<Edge>[] adj;

    // Constructor
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
    }

    // Method to insert edge to adjacency list
    void insert(int u, int v, int wt) {
        adj[u].add(new Edge(v, wt));
    }
}

class BellmanFord {
    static void bellmanFord(Graph g, int s, int[] dist) {
        // Initialize distances from source to all other vertices with max distance 
        for (int i = 0; i < g.v; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;                        // Source vertex has 0 distance

        // Relax all edges |V| - 1 times 
        // Shortest path from source to any other vertex can have at-most |V| - 1 edges
        for (int i = 1; i < g.v; i++)
            for (int j = 0; j < g.v; j++) 
                for (int k = 0; k < g.adj[j].size(); k++) {
                    // Get edge from linked list
                    Edge e = g.adj[j].remove();
                    int v = e.dest, wt = e.wt;

                    // Compare distances
                    if (dist[j] != Integer.MAX_VALUE && dist[j] + wt < dist[v])
                        dist[v] = dist[j] + wt;

                    // Add edge back to list
                    g.adj[j].add(e);
                }

        // Check for negative-weight cycles
        // If we get a shorter path again, then there is a cycle
        for (int j = 0; j < g.v; j++) 
            for (int k = 0; k < g.adj[j].size(); k++) {
                // Get edge from linked list
                Edge e = g.adj[j].remove();
                int v = e.dest, wt = e.wt;

                // Compare distances
                if (dist[j] != Integer.MAX_VALUE && dist[j] + wt < dist[v]) {
                    System.out.println("-1");
                    return;
                }

                // Add edge back to list
                g.adj[j].add(e);
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read vertices and edges
        int n = sc.nextInt(), m = sc.nextInt();

        // Read edges and design graph
        Graph g = new Graph(n);
        for (int i = 0; i < m; i++)
            g.insert(sc.nextInt(), sc.nextInt(), sc.nextInt());
        
        // Read start/source vertex
        int s = sc.nextInt();
        
        // Result array
        int dist[] = new int[g.v];

        // Output
        bellmanFord(g, s, dist);

        for (int i : dist)
            System.out.print((i == Integer.MAX_VALUE ? -1 : i) + " ");
        System.out.println();
    }
}