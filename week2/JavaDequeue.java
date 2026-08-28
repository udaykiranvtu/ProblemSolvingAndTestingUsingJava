import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        
        int n = in.nextInt(); // total numbers
        int m = in.nextInt(); // subarray size
        
        int maxUnique = 0;
        
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            
            deque.add(num);
            set.add(num);
            
            if (deque.size() == m) {
                // update max unique count
                maxUnique = Math.max(maxUnique, set.size());
                
                // remove first element to slide window
                int removed = deque.remove();
                if (!deque.contains(removed)) {
                    set.remove(removed);
                }
            }
        }
        
        System.out.println(maxUnique);
    }
}
