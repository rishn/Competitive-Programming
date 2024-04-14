import java.util.*;

class MyStack {
  // Hidden queue
  Queue<Integer> q = new LinkedList<>();
  
  void push(int x) {
	q.add(x);
  }
  
  boolean empty() {
    return q.isEmpty();
  }	
  
  int pop() {
    // Empty case
    if (empty())
      return -1;
    
    // Create a new queue and add all elements except the rear to the same
  	Queue q1 = new LinkedList<>();
    while (q.size() > 1)
      q1.add(q.remove());
    
    // Dequeue the rear element
    int x = q.remove();
    
    // Assign original to new queue
    q = q1;
    
    // Return rear element
    return x;
  }
  
  int top() {
    // Empty case
    if (empty())
      return -1;
    
    // Create a new queue and add all elements except the rear to the same
  	Queue q1 = new LinkedList<>();
    while (q.size() > 1)
      q1.add(q.remove());
    
    // Dequeue the rear element
    int x = q.remove();
    q1.add(x);
      
    // Assign original to new queue
    q = q1;
    
    // Return rear element
    return x;
  }
}

class StackFromQueue {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    // Stack using Queue
    MyStack stk = new MyStack();
    
    // Read first operation
  	int t = sc.nextInt();
    
    while (t != -1) {
      switch (t) {
        // Push
        case 1:
          stk.push(sc.nextInt());
          break;
        
        // Pop
        case 2:
          System.out.println("Pop: " + stk.pop());
          break;
        
        // Top
        case 3:
          System.out.println("Top element: " + stk.top());
          break;
        
        // Is Empty
        case 4:
          System.out.println("Is empty: " + stk.empty());
          break;
          
        default:
          System.out.println("Invalid input");
          break;
      }
    
      // Next operation
      t = sc.nextInt();
    }
  }
}