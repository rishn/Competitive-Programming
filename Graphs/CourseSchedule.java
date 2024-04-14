import java.util.*;

class Graph {
  // No. of vertices
  int v;
  
  // Indegree array
  int[] inDegree;
  
  // Adjacency list
  LinkedList<Integer>[] adj;
  
  // Constructor
  Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList();
        inDegree = new int[v];
    }
    
    // Add vertex connected via edge to adjacency list of vertex
    void addEdge(int v, int u) {
        adj[u].add(v);
        inDegree[v]++;
    }
    
    // BFS with Queue
    boolean BFS(Queue<Integer> q) {
        int count = 0;

        // Countinue until queue is empty
        while (! q.isEmpty()) {
            // Pop vertex from queue and increment count of vertices traversed
            int v = q.remove();
            count++;

            // Reduce the in-degrees of connected vertices
            for (int u : adj[v]) {
                inDegree[u]--;

                // If all edges connecting connected vertex are traversed, add vertex to queue
                if (inDegree[u] == 0)
                    q.add(u);
            }
        }

        // Return if count of vertices traversed equals number of vertices
        return count == v;
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
    
        // Queue for BFS traversal
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++)
            // If no other vertex is connected to current vertex, add it to queue
            if (g.inDegree[i] == 0)
                q.add(i);
        
        // Output
        System.out.println(g.BFS(q) ? "True" : "False");
    }
}
