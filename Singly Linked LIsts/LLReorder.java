import java.util.*;

class ReorderLL {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    
    // Declare LL
    LinkedList<Integer> ll = new LinkedList<>(), res = new LinkedList<>();
    
    // Read size of LL
    int n = sc.nextInt();
    
    // Read LL
    for (int i = 0; i < n; i++)
      ll.add(sc.nextInt());
   	
    // Alt remove elements from LL at both ends to new LL
    while (ll.size() > 0) {
      res.add(ll.remove(ll.size() - 1));
      
      if (ll.size() == 0)
        break;
      
	  res.add(ll.remove(0)); 
    }
    
    // Output
    res.forEach((i)->System.out.print(i + " "));
  }
}