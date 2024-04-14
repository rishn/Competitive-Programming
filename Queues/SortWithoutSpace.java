import java.util.*;

class QueueWoSpace {
    static int minIndex(Queue<Integer> q, int i) {
        // Iniitialize values
        int index = -1, min = Integer.MAX_VALUE;
        
        // Find index of min value
        for (int j = 0; j < q.size(); j++) {
            int curr = q.poll();
            if (curr <= min && j < i) {
                index = j;
                min = curr;
            }
            q.add(curr);
        }
        
        return index;
    }
  
    static void enqueueMin(Queue<Integer> q, int index) {
        int min = 0;
        for (int i = 0; i < q.size(); i++) {
            int curr = q.poll();
            if (i != index)
                q.add(curr);
            else
                min = curr;
        }
        q.add(min);
    }
    
    static void sort(Queue<Integer> q) {
        for (int i = 1; i < q.size(); i++)
            enqueueMin(q, minIndex(q, q.size() - i));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Intitialize queue
        Queue<Integer> q = new LinkedList<Integer>();
        
        // Read size of Queue
        int n = sc.nextInt();
        
        // Read inputs
        for (int i = 0; i < n; i++)
            q.add(sc.nextInt());
        
        // Sort queue
        sort(q);
        
        // Print queue
        while (! q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}
