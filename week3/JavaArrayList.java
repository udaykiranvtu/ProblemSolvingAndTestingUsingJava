import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of lines
        List<List<Integer>> list = new ArrayList<>();

        // Read each line of integers
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt(); // number of integers in this line
            List<Integer> innerList = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                innerList.add(sc.nextInt());
            }
            list.add(innerList);
        }

        int q = sc.nextInt(); // number of queries
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt(); // line number
            int y = sc.nextInt(); // position in line

            // Check bounds before accessing
            if (x <= list.size() && y <= list.get(x - 1).size()) {
                System.out.println(list.get(x - 1).get(y - 1));
            } else {
                System.out.println("ERROR!");
            }
        }

        sc.close();
    }
}
