// DIALS ALGORITHM
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

class Dial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read vertices and edges
        int n = sc.nextInt(), m = sc.nextInt();

        // Initialize distance array with max distances
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = n * m;

        // Initialize Dial's List
        LinkedList<Integer>[] dialsList = new LinkedList[n * m + 1];
        for (int i = 0; i <= n * m; i++) 
            dialsList[i] = new LinkedList();

        // Initialize graph object
        Graph g = new Graph(n);

        // Read edges and design graph
        for (int i = 0; i < m; i++)
            g.insert(sc.nextInt(), sc.nextInt(), sc.nextInt());

        // Read start vertex and set initial values to distance array and Dial's list
        int s = sc.nextInt();
        dist[s] = 0;
        dialsList[0].add(s);

        // Iterate through Dial's list
        for (int i = 0; i <= n * m; i++) {
            // Get the first non-empty LL from Dial's list
            if (dialsList[i].size() != 0)
                // Traverse the LL
                for (int j = 0; j < dialsList[i].size(); j++) {
                    // Get the first vertex from LL
                    int v = dialsList[i].remove();

                    // Iterate through connected edges of vertex
                    for (Edge k : g.adj[v])
                        // If connected vertex is reached with lesser cost from current vertex 
                        if (k.wt + dist[v] < dist[k.dest]) {
                            // Remove vertex from Dial's list
                            if (dialsList[dist[k.dest]].contains(k.dest))
                                dialsList[dist[k.dest]].remove(k.dest);
                            
                            // Update distance array
                            dist[k.dest] = k.wt + dist[v];

                            // Add vertex to Dial's List at new index
                            dialsList[dist[k.dest]].add(k.dest);
                        }
                    
                    // Add vertex back to LL
                    dialsList[i].add(v);
                }
        }

        // Print distance array
        for (int i = 0; i < n; i++)
            System.out.print(dist[i] + " ");
    }
}
