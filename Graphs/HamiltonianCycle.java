// INPUT
/*
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0

5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 0
0 1 1 0 0 
*/

// OUTPUT
/*
Solution Exists: Following is one Hamiltonian Cycle
0 1 2 4 3 0

Solution does not exist
*/

// CODE
import java.util.Scanner;

class HamiltonianCycle {
    final int V = 5;
    int path[];

    boolean isSafe(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
 
        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == V) {
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < V; v++) 
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                
                if (hamCycleUtil(graph, path, pos + 1) == true)
                    return true;
                
                path[pos] = -1;
            }
        
        return false;
    }

    int hamCycle(int graph[][]) {
        path = new int[V];
        
        path[0] = 0;
        for (int i = 1; i < V; i++)
            path[i] = -1;

        if (hamCycleUtil(graph, path, 1) == false) {
            System.out.println("Solution does not exist");
            return 0;
        }
 
        printSolution(path);
        return 1;
    }

    void printSolution(int path[])
    {
        System.out.println("Solution Exists: Following is one Hamiltonian Cycle");
        for (int i = 0; i < V; i++)
            System.out.print(path[i] + " ");
        System.out.println(path[0]);
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        HamiltonianCycle hamiltonian = new HamiltonianCycle();

        int n = sc.nextInt();
        int graph[][] = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = sc.nextInt();
        
        hamiltonian.hamCycle(graph);

        sc.close();
    }
}