import java.util.*;

class MyQueue {
  // Hidden stack
  Stack<Integer> stk = new Stack<>();
  
  void enqueue(int x) {
    stk.push(x);
  }
  
  int dequeue() {
    // New stack
    Stack<Integer> s2 = new Stack<>();
    
    // Pop all elements except the last and add to new stack
    while (stk.size() > 1)
      s2.push(stk.pop());
    
    // Pop the bottom of stack
    int x = stk.pop();
    
    // Push all elements from new stack to original
    while (! s2.isEmpty())
      stk.push(s2.pop());
    
    // Return bottom of stack (front of queue)
    return x;
  }
  
  // Function to print queue elements
  void display() {
    // New stack
    Stack<Integer> s2 = new Stack<>();
    
    // Push all elements from original stack to new
    while (! stk.isEmpty())
      s2.push(stk.pop());
    
    // Display elements by popping from new stack (front to rear)
   	System.out.println("Queue elements are:");
  	while (! s2.isEmpty())
      System.out.print(s2.pop() + " ");
  }
}

class QFromStack {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    //Queue
    MyQueue q = new MyQueue();
    
    // Read no. of enqueue operations
    int n = sc.nextInt();
    
    // Perform enqueue operations
    for (int i = 0; i < n; i++)
      q.enqueue(sc.nextInt());
    
    // Read no. of dequeue operations
    n = sc.nextInt();
    
    // Perform dequeue operations
    for (int i = 0; i < n; i++)
      q.dequeue();
    
    // Display queue
    q.display();
  }
}