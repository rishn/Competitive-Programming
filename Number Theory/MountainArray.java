import java.util.*;

// Required interface with given methods
interface MountainArray {
    List<Integer> arr = new ArrayList<>();
    
    int get(int k);
    
    int length();
}

// Class implementing interface
class Mountain implements MountainArray {
    public Mountain(Scanner sc) {
        // Read array and insert into mountain array
        int n = Integer.parseInt(sc.nextLine());
        String[] str = sc.nextLine().split(" ");
        for (String i : str)
            arr.add(Integer.parseInt(i));
    }
    
    public int get(int k) {
        return arr.get(k);
    }
    
    public int length() {
        return arr.size();
    }
}

class MntnArray {
    static int binSearch(Mountain mA, int l, int r, int target) {
        // Base case
        if (l > r)
            return -1;
        
        // Middle element
        int m = l + (r - l) / 2;
        
        // If target found
        if (mA.get(m) == target)
            return m;
        
        // If target is on left side of subarray
        if (target < mA.get(m))
            return binSearch(mA, l, m - 1, target);
        
        // If target is on right side of subarray
        return binSearch(mA, m + 1, r, target);
    }
    
    static int revBinSearch(Mountain mA, int l, int r, int target) {
        // Base case
        if (l > r)
            return -1;
        
        // Middle element
        int m = l + (r - l) / 2;
        
        // If target found
        if (mA.get(m) == target)
            return m;
        
        // If target is on left side of subarray
        if (target > mA.get(m))
            return revBinSearch(mA, l, m - 1, target);
        
        // If target is on right side of subarray
        return revBinSearch(mA, m + 1, r, target);
    }
    
    static int findTarget(Mountain mA, int target) {
        // Find peak
        int l = 0, r = mA.length() - 1, m;
        while (l < r) {
            // Find middle of pointers
            m = l + (r - l) / 2;
            
            // If elements are increasing at middle
            if (mA.get(m) < mA.get(m + 1))
                // Update left
                l = m + 1;
            
            // Else
            else
                // Update right
                r = m;
        }
        
        // Left pointer points to peak
        m = l;
        
        // If target found
        if (mA.get(m) == target)
            return m;
        
        // Search left side of mountain array
        int res = -1;
        if (target < mA.get(m) && target >= mA.get(0))
            res = binSearch(mA, 0, m - 1, target);
        
        // Seaarch right side of mountain array if needed
        if (res == -1)
            return revBinSearch(mA, m + 1, mA.length() - 1, target);
        else
            return res;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        // Initialize mountain array
        Mountain mA = new Mountain(sc);
        
        // Read target
        int t = sc.nextInt();
        
        // If flow has reached here, target is not present in array
        System.out.println(findTarget(mA, t));
    }
}